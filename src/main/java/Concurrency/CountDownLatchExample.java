package Concurrency;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;

class BoundedBufferLatch {
    @Getter
    @Setter
    private TaskLatch[] buffer;
    @Getter
    @Setter
    private int size, count;

    public BoundedBufferLatch(int size) {
        buffer = new TaskLatch[size];
        this.size = size;
        count = 0;
    }

    public synchronized void put(TaskLatch value) throws InterruptedException {
        buffer[count]=value;
        count++;
        notifyAll();
    }

    public synchronized TaskLatch get() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        TaskLatch value = buffer[count-1];
        count--;
        notifyAll();
        return value;
    }
    //execute tasks in buffer
    public  synchronized void execute() {
        while (count > 0) {
            TaskLatch value = buffer[count-1];
            count--;
            new Thread(value::run).start();
        }
    }
}

class TaskLatch implements Runnable {

    public void run() {
        try {
            System.out.println("Task Class is running");
            System.out.println(Thread.currentThread().getName());
            // process the value
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}

class FreeUpBufferQueueLatch implements Runnable{

    private CountDownLatch countDownLatch;
    private BoundedBufferLatch queue;
    private TaskLatch[] buffer;
    private int count;
    FreeUpBufferQueueLatch(CountDownLatch countDownLatch, BoundedBufferLatch queue) {
        this.countDownLatch = countDownLatch;
        this.queue = queue;
        buffer=this.queue.getBuffer();
        count=this.queue.getCount();
    }
    @Override
    public void run() {
        System.out.println("Worker Thread is running " + Thread.currentThread().getName());
        int i=0;
        while (i < 5) {
            TaskLatch value = buffer[count-1];
            buffer[count-1]=null;
            i++;
            count--;
            new Thread(value::run).start();
        }
        queue.setCount(count);
        queue.setBuffer(buffer);
        countDownLatch.countDown();
    }
}

class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        /*
         * The Problem with Countdown Latch is that it is not reusable
         * The count here in the counter for the latch, and it decrements by 1 each time countDown() is called
         * e.g: if the count is 1, and countDown() is called, the count becomes 0 and the latch is released
         * The countDownLatch.await() method blocks the current thread until the count reaches zero
         */

        CountDownLatch latch = new CountDownLatch(1);

        int numTasks = 1000;
        int qSize=100;
        BoundedBufferLatch queue = new BoundedBufferLatch(qSize);
        for(int i = 0; i < numTasks; i++) {
            if(queue.getCount()>=qSize) {
                System.out.println("Main thread Paused");
                //add latch and executeTop5
                Thread thread= new Thread(new FreeUpBufferQueueLatch(latch, queue));
                thread.start();
                latch.await();
                System.out.println("Main thread Resumed");
            }
            queue.put(new TaskLatch());
        }
        queue.execute();
    }
}

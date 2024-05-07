package Concurrency;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class BoundedBufferBarrier {
    @Getter
    @Setter
    private TaskBarrier[] buffer;
    @Getter
    @Setter
    private int size, count;

    public BoundedBufferBarrier(int size) {
        buffer = new TaskBarrier[size];
        this.size = size;
        count = 0;
    }

    public synchronized void put(TaskBarrier value) throws InterruptedException {
        buffer[count]=value;
        count++;
        notifyAll();
    }

    public synchronized TaskBarrier get() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        TaskBarrier value = buffer[count-1];
        count--;
        notifyAll();
        return value;
    }
    //execute tasks in buffer
    public  synchronized void execute() {
        while (count > 0) {
            TaskBarrier value = buffer[count-1];
            count--;
            new Thread(value::run).start();
        }
    }
}

class TaskBarrier implements Runnable {

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

class FreeUpBufferQueueBarrier implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private BoundedBufferBarrier queue;
    private TaskBarrier[] buffer;
    private int count;
    FreeUpBufferQueueBarrier(CyclicBarrier cyclicBarrier, BoundedBufferBarrier queue) {
        this.cyclicBarrier = cyclicBarrier;
        this.queue = queue;
        buffer=this.queue.getBuffer();
        count=this.queue.getCount();
    }
    @Override
    public void run() {
        System.out.println("Worker Thread is running " + Thread.currentThread().getName());
        int i=0;
        while (i < 5) {
            TaskBarrier value = buffer[count-1];
            buffer[count-1]=null;
            i++;
            count--;
            new Thread(value::run).start();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        queue.setCount(count);
        queue.setBuffer(buffer);

    }
}

class CyclicBarrieExample {
    public static void main(String[] args) throws InterruptedException {
        /*
         * The Problem with Latch of not resuability is solved by CyclicBarrier
         * It is used when we want to execute a task after all the threads
         * have completed their task
         * we are using await() at two places.
         * 1. For the FreeUP code and
         * 2. For the Main thread to resume
         * so that is why Barrier has 2 Parties
         */

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        int numTasks = 1000;
        int qSize=100;
        BoundedBufferBarrier queue = new BoundedBufferBarrier(qSize);
        for(int i = 0; i < numTasks; i++) {
            if(queue.getCount()>=qSize) {
                System.out.println("Main thread Paused");
                //add Barrier and executeTop5
                Thread thread= new Thread(new FreeUpBufferQueueBarrier(cyclicBarrier, queue));
                thread.start();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Main thread Resumed");
            }
            queue.put(new TaskBarrier());
        }
        queue.execute();
    }
}

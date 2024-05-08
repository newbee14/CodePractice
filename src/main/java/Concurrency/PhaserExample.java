package Concurrency;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Phaser;


class BoundedBufferPhaser {
    @Getter
    @Setter
    private TaskPhaser[] buffer;
    @Getter
    @Setter
    private int size, count;

    public BoundedBufferPhaser(int size) {
        buffer = new TaskPhaser[size];
        this.size = size;
        count = 0;
    }

    public synchronized void put(TaskPhaser value) throws InterruptedException {
        buffer[count]=value;
        count++;
        notifyAll();
    }

    public synchronized TaskPhaser get() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        TaskPhaser value = buffer[count-1];
        count--;
        notifyAll();
        return value;
    }
    //execute tasks in buffer
    public  synchronized void execute() {
        while (count > 0) {
            TaskPhaser value = buffer[count-1];
            count--;
            new Thread(value::run).start();
        }
    }
}

class TaskPhaser implements Runnable {

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

class FreeUpBufferQueuePhaser implements Runnable{

    private Phaser phaser;
    private BoundedBufferPhaser queue;
    private TaskPhaser[] buffer;
    private int count;
    FreeUpBufferQueuePhaser(Phaser phaser, BoundedBufferPhaser queue) {
        this.queue = queue;
        this.phaser = phaser;
        buffer=this.queue.getBuffer();
        count=this.queue.getCount();
    }
    @Override
    public void run() {
        System.out.println("Worker Thread is running " + Thread.currentThread().getName());
        int i=0;
        while (i < 5) {
            TaskPhaser value = buffer[count-1];
            buffer[count-1]=null;
            i++;
            count--;
            new Thread(value::run).start();
        }
        queue.setCount(count);
        queue.setBuffer(buffer);
        phaser.arrive();

    }
}

class PhaserExample {
    public static void main(String[] args) throws InterruptedException {
        /*
        * 1. If the buffer is full, we create a new thread which executes
        * the top 5 tasks and then resumes the main thread
        * 2. We then wait for the buffer function to complete and main thread to resume
        * 3. We use phaser to synchronize the main thread and the worker thread
        * 4. The parties are incremented in the phaser when the worker thread completes its task
        * so if you want to wait at two places then there will be two parties and so on
        * 5. We use arriveAndAwaitAdvance() and arrive() to wait and resume the main thread
         */
        int numTasks = 1000;
        int qSize=100;
        BoundedBufferPhaser queue = new BoundedBufferPhaser(qSize);

        Phaser phaserLatch = new Phaser(2);
        for(int i = 0; i < numTasks; i++) {
            if(queue.getCount()>=qSize) {
                System.out.println("Main thread Paused");
                //add Barrier and executeTop5
                Thread thread= new Thread(new FreeUpBufferQueuePhaser(phaserLatch,queue));
                thread.start();
                phaserLatch.arriveAndAwaitAdvance();
                System.out.println("Main thread Resumed");
            }
            queue.put(new TaskPhaser());
        }
        queue.execute();
    }
}

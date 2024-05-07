package Concurrency;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ThreadsExample implements Runnable, Callable {

    public static void main(String[] args) throws InterruptedException {
        new ThreadsExample().threadExample1();

    }

    @SneakyThrows
    private void threadExample1() throws InterruptedException {
        Thread thread5 = new Thread();
        thread5.setPriority(1);
        Thread thread1 = new Thread(()-> {
                System.out.println("Thread 1 is running");
                System.out.println("t1.getName() = " + Thread.currentThread().getName());
            }
        );

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 is running");
                System.out.println("t2.getName() = " + Thread.currentThread().getName());
                try {
                    thread1.sleep(1000);
                    System.out.println("Thread 1 is done sleeping");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

//        thread1.start();

        thread2.start();
        thread1.join();
        Thread thread3 = new Thread(this::run, "new-tread");
        thread3.start();

        //implement a thread using Callable interface and pass the return to a new thread
        ThreadsExample threadsExample = new ThreadsExample();
        Thread thread4 = new Thread(() -> {
            try {
                System.out.println("Thread 4 is running");
                System.out.println("t4.getName() = " + Thread.currentThread().getName());
                System.out.println("threadsExample.call() = " + threadsExample.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread4.start();
        thread5 = new Thread(String.valueOf(new ThreadsExample().call()));
        thread5.start();
        //excecute all threads in parallel

    }

    @Override
    public void run() {
        System.out.println("Thread 3 is running");
        System.out.println("t3.getName() = " + Thread.currentThread().getName());
    }

    @Override
    public Object call() throws Exception {
        return 123;
    }
}


//=====================================================Thread with Queue support=====================================================
class BoundedBuffer {
    @Getter
    @Setter
    private Task[] buffer;
    @Getter
    @Setter
    private int size, count;

    public BoundedBuffer(int size) {
        buffer = new Task[size];
        this.size = size;
        count = 0;
    }

    public synchronized void put(Task value) throws InterruptedException {
        if(count == size) {
            // wait until there is space in the buffer refer latch and barrier for this
            wait();
        }
        buffer[count]=value;
        count++;
        notifyAll();
    }

    public synchronized Task get() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        Task value = buffer[count-1];
        count--;
        notifyAll();
        return value;
    }
    //execute tasks in buffer
    public  synchronized void execute() {
        while (count > 0) {
            Task value = buffer[count-1];
            count--;
            new Thread(value::run).start();
        }
    }
}

class Task implements Runnable {

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

class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
         * The Problem with thread class is that it has no default support for queueing tasks
         * This example solves that problem by creating a BoundedBuffer class that queues tasks
         */

        int numTasks = 1000;
//        int qSize=100;
        BoundedBuffer queue = new BoundedBuffer(numTasks);
        for(int i = 0; i < numTasks; i++) {
            queue.put(new Task());
        }
        queue.execute();
    }
}
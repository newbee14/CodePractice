package Concurrency;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                new CustomThreadFactory(), new CustomRejectedExecutionHandler());

        for (int i = 0; i < 10; i++) {
            executor.submit(()->{
                System.out.println("Thread name "+Thread.currentThread().getName());
            });
            System.out.println(executor);
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println("executor.getQueue() = " + executor.getQueue().size());
        while(!executor.getQueue().isEmpty()){
            System.out.println("executor.getQueue() = " + executor.getQueue().size());
        }
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected "+ executor);

    }
}
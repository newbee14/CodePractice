package Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Question: Implement a thread-safe counter using locks.
 */
public class Question1 {
    private AtomicInteger count = new AtomicInteger(0);
    private final Object lock = new Object();

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        String[] arr = {
                "+", "-", "+", "-", "+", "+", "+", "+", "+", "-",
                "+", "+", "-", "+", "-", "+", "+", "+", "+", "+",
                "-", "+", "+", "-", "+", "+", "+", "+", "+", "-",
                "+", "+", "-", "+", "+", "+", "+", "+", "-", "+",
                "+", "-", "+", "+", "+", "+", "+", "-", "+", "+",
                "+", "+", "+", "+", "-", "+", "+", "+", "+", "-",
                "+", "-", "+", "-", "+", "-", "+", "+", "+", "+",
                "-", "+", "+", "+", "+", "-", "+", "+", "+", "+",
                "-", "+", "+", "+", "-", "+", "-", "+", "+", "+",
                "+", "-", "+", "+", "+", "+", "+", "-", "+", "+",
                "+", "+", "-", "+", "+", "+", "+", "-", "+", "+",
                "+", "+", "-", "+", "+", "+", "+", "-", "+"
        };
        Question1 counter = new Question1(); // Create a single instance of Question1
        CountDownLatch latch = new CountDownLatch(100);
        //create new array of 100 operations like arr

        for (int i = 0; i < 100; i++) {
            // Select randomly from the array
            String temp = arr[i];
            if (temp.equals("+")) {
                new Thread(() -> {
                    System.out.println("Incrementing and thread is " + Thread.currentThread().getName());
                    counter.increment();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    latch.countDown(); // Signal thread completion
                }).start();
            } else {
                new Thread(() -> {
                    System.out.println("Decrementing and thread is " + Thread.currentThread().getName());
                    counter.decrement();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    latch.countDown(); // Signal thread completion
                }).start();
            }
        }

        // Wait for all threads to finish
        latch.await();

        // Now all threads are finished, print the final count
        System.out.println("Final Counter " + counter.getCount());
    }
}

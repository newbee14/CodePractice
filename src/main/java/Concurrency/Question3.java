package Concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/*
 *Question: Implement a web crawler that uses multiple threads to fetch pages in parallel.
 * There can two types of impl: A web page in next by next i.e: you have reached one page then you see another page and so on.
 * Other can be that you already know all the pages that exists and have their path
 * We will be doing the 1st one and second one is quite straightforward.
 */
public class Question3 {
    public static void main(String[] args) {
        //we have used this class from Question2 as we have already created one thread safe LL
        ConcurrentLinkedList<Integer> list = new ConcurrentLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,10,1,
                TimeUnit.MINUTES,new ArrayBlockingQueue<>(100),new ThreadPoolExecutor.DiscardPolicy());

        AtomicReference<Node<Integer>> curr = new AtomicReference<>(list.getHead());
        while (curr.get() != null) {
            Node<Integer> current = curr.get();
            executor.submit(() -> {
                //Your output might be jumbled but the access to the list is thread safe and 1by1 access is guaranteed
                    System.out.println(Thread.currentThread().getName() + " Hello " + current.data);
            });
            curr.set(current.next.get());
        }
        executor.shutdown(); // Shutdown executor after submitting tasks
    }
}

package Concurrency;

import java.util.concurrent.atomic.AtomicReference;

/*
    * Question: Implement a thread-safe linked list using atomic operations.
 */



class Node<T> {
    T data;
    AtomicReference<Node<T>> next;

    public Node(T data) {
        this.data = data;
        this.next = new AtomicReference<>(null);
    }
}

class ConcurrentLinkedList<T> {
    private AtomicReference<Node<T>> head;

    public ConcurrentLinkedList() {
        head = new AtomicReference<>(null);
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if(head.get() == null) {
            head.set(newNode);
            return;
        }

        Node<T> curr = head.get();
        while(curr.next.get()!=null){
            curr=curr.next.get();
        }
        curr.next.set(newNode);
    }

    public boolean remove(T element) {
        Node<T> curr = head.get();
        Node<T> prev = null;
        if(curr==null) return false;
        if(curr.data.equals(element)){
            head.compareAndSet(curr, curr.next.get());
            return true;
        }
        curr=curr.next.get();
        prev=curr;
        while (curr != null) {
            if (curr.data.equals(element)) {
                prev.next.set(curr.next.get());
                return true;
            }
            prev = curr;
            curr = curr.next.get();
        }
        return false;
    }

    public void display() {
        Node<T> curr = head.get();
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next.get();
        }
        System.out.println();
    }
}

public class Question2 {

    public static void main(String[] args) {
        ConcurrentLinkedList<Integer> list = new ConcurrentLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.display(); // Output: 3 2 1

        list.remove(2);
        list.display(); // Output: 3 1
    }
}


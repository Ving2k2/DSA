package Week4.ThucHanh;

import java.util.Iterator;
import java.util.Queue;

public class LinkedQueue<E> implements QueueInterface<E>{
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            next = null;
        }
    }
    private Node queue = null;
    private int n = 0;

    @Override
    public void enqueue(E element) {
        Node tmp = queue;
        Node pre = null;
        int count = 0;

        if (n == 0) queue = new Node(element);
        else {
            while (count < n) {
                pre = tmp;
                tmp = tmp.next;
                count++;
            }
            pre.next = new Node(element);
        }
        n++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        else {
            Node tmp = queue;
            queue = tmp.next;
            n--;
            return tmp.element;
        }
    }

    @Override
    public E peek() {
        return isEmpty() ? null : queue.element;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private class iterLikedList implements Iterator<E> {
        private Node currentNode = queue;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }
        @Override
        public E next() {
            // TODO Auto-generated method stub
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new iterLikedList();
    }
}

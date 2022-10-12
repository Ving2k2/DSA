package Week4.ThucHanh;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        queue = (E[]) new Object[capacity];
    }
    public ArrayQueue() {
        queue = (E[]) new Object[default_size];
    }

    public void print() {
        for (int i = 0; i < n; i++) System.out.print(queue[i] + " ");
        System.out.println();
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (n == queue.length) throw new IllegalStateException("Queue is full");
        else queue[n++] = element;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        else {
            int count = 0;
            E ans = queue[0];
            while (count <= n - 1) queue[count] = queue[++count];
            queue[count] = null;
            n--;
            return ans;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        else {
            return queue[0];
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }


    private class iterArray<E> implements Iterator<E> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public E next() {
            if (hasNext()) return (E) queue[i++];
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueue.iterArray();
    }
}

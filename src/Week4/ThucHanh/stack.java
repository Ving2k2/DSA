package Week4.ThucHanh;

import java.util.Iterator;

public class stack<E> implements stackInterface<E> {
    private E[] data;
    private int size = -1;
    public static final int CAPACITY = 1000;

    public stack() {
        data = (E[]) new Object[CAPACITY];
    }

    public stack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Stack is full");
        else data[++size] = element;

    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        else {
            E ans = data[size];
            data[size--] = null;
            return ans;
        }
    }

    @Override
    public boolean isEmpty() {
        return size < 0;
    }

    @Override
    public int size() {
        return size + 1;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}

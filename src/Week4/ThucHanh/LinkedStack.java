package Week4.ThucHanh;

import Week3.ThucHanh.SimpleLinkedList;

import java.util.Iterator;

public class LinkedStack<E> implements StackInterface<E> {

    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            next = null;
        }
    }

    private Node stack = null;
    private int n = -1;

    public void printStack()
    {
        Node tmp = stack;

        System.out.print("LinkedList: ");

        while (tmp != null) {
            System.out.print(tmp.element + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
    public void push(E element) {
        // Thêm một phần tử vào stack
        Node tmp = stack;
        Node pre = null;
        int count = -1;

        if (n == -1) stack = new Node(element);
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
    public E pop() {
        // Lấy một phần tử khỏi stack
        int count = 0;
        Node pre = null, tmp = stack;
        if (n == 0) {
            stack = null;
            n--;
            return tmp.element;
        }
        while (count < n) {
            pre = tmp;
            tmp = tmp.next;
            count++;
        }

        if(tmp != null) {
            n--;
            return tmp.element;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra stack rỗng
        return n < 0;
    }

    @Override
    public int size() {
        return n + 1;
    }

    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack
        int count = 0;
        Node pre = null, tmp = stack;
        while (count < n) {
            pre = tmp;
            tmp = tmp.next;
            count++;
        }

        if(tmp != null) {
            return tmp.element;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }
    class StackIterator implements Iterator<E> {

        private Node currentNode = stack;

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
}


package Week3.ThucHanh;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void printList()
    {
        Node tmp = top;

        System.out.print("LinkedList: ");

        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void add(T data) {
        Node tmp = new Node(data);
        if (top == null) top = bot = tmp;
        else {
            tmp.next = top;
            top = tmp;
        }
        n++;
    }

    public void addBot(T data) {
        Node tmp = new Node(data);
        if (bot == null) top = bot = tmp;
        else {
            while (bot.next != null) bot = bot.next;
            bot.next = tmp;
        }
        n++;
    }
    public T get(int i) {
        int count = 0;
        Node tmp = top, pre;
        if (i == 0) return top.data;
        while (count < i) {
            pre = tmp;
            tmp = tmp.next;
            count++;
        }
        return tmp.data;
    }
    public void set(int i, T data){
        int count = 0;
        Node tmp = top, pre;
        Node change = new Node(data);
        while (count <= i) {
            pre = tmp;
            tmp = tmp.next;
            if (count == i) tmp = change;
            count++;
        }
    }
    public boolean isContain(T data) {
        Node tmp = top, pre;
        Node change = new Node(data);
        while (tmp != null && tmp.data != data) {
            pre = tmp;
            tmp = tmp.next;
        }
        return tmp.data == data;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public T removeTop() {
        Node tmp = top;
        if (top != null) {
            top = tmp.next;
            n--;
            return top.data;
        }
        return null;
    }
    public T removeBot() {
        int count = 0;
        Node pre = null, tmp = top;
        while (count < n - 1) {
            pre = tmp;
            tmp = tmp.next;
            count++;
        }

        if(pre != null) {
            pre.next = tmp.next;
            return tmp.data;
        }
        n--;
        return null;
    }
    public void remove(T data) {
        Node tmp = top, prev = null;

        if (top != null && tmp.data == data) {
            top = tmp.next;
        }

        while (tmp != null && tmp.data != data) {
            prev = tmp;
            tmp = tmp.next;
        }

        if (tmp != null) {
            prev.next = tmp.next;
        }

        if (tmp == null) {
            System.out.println("Data not found");
        }
        n--;
    }

}

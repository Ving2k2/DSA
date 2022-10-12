package Week4.ThucHanh;


public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>();
        S.push(5);
        S.push(3);
        System.out.println(S.size());
        System.out.println(S.pop());
        System.out.println(S.isEmpty());
        System.out.println(S.pop());
        System.out.println(S.isEmpty());
        System.out.println(S.pop());
        S.push(7);
        S.push(9);
        System.out.println(S.top());
        S.push(4);
        System.out.println(S.size());
        System.out.println(S.pop());
        S.push(6);
        S.push(8);
        System.out.println(S.pop());

        System.out.println();
        LinkedStack<Integer> S2 = new LinkedStack<>();
        S2.push(5);
        S2.push(3);
        System.out.println(S2.size());
        System.out.println(S2.pop());
        System.out.println(S2.isEmpty());
        System.out.println(S2.pop());
        System.out.println(S2.isEmpty());
        System.out.println(S2.pop());
        S2.push(7);
        S2.push(9);
        System.out.println(S2.top());
        S2.push(4);
        System.out.println(S2.size());
        System.out.println(S2.pop());
        S2.push(6);
        S2.push(8);
        System.out.println(S2.pop());

        System.out.println();
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(5);
        q.enqueue(3);
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        q.enqueue(7);
        q.enqueue(9);
        System.out.println(q.peek());
        fun1(10);

        System.out.println();
        ArrayQueue<Integer> q2 = new ArrayQueue<>();
        q2.enqueue(5);
        q2.enqueue(3);
        System.out.println(q2.size());
        System.out.println(q2.dequeue());
        System.out.println(q2.isEmpty());
        System.out.println(q2.dequeue());
        System.out.println(q2.isEmpty());
        System.out.println(q2.dequeue());
        q2.enqueue(7);
        q2.enqueue(9);
        System.out.println(q2.peek());
        fun2(10);

    }

    public static void fun1(int n) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(0);
        q.enqueue(1);
        for (int i = 0; i < n; i++) {
            int a = q.dequeue();
            int b = q.dequeue();
            System.out.print(a + " ");
            q.enqueue(b);
            q.enqueue(a + b);
        }
        System.out.println();
    }

    public static void fun2(int n) {
        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(0);
        q.enqueue(1);
        for (int i = 0; i < n; i++) {
            int a = q.dequeue();
            int b = q.dequeue();
            System.out.print(a + " ");
            q.enqueue(b);
            q.enqueue(a + b);
        }
        System.out.println();
    }
}

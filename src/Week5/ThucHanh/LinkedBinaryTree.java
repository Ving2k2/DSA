package Week5.ThucHanh;

import java.util.LinkedList;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    private int n = 0;
    private Node<E> root;

    protected static class Node<E> {
        private E element;        // an element stored at this node
        private Node<E> parent;    // a reference to the parent node (if any)
        private Node<E> left;    // a reference to the left child
        private Node<E> right;    // a reference to the right child

        // Constructs a node with the given element and neighbors. ∗/
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            // Sinh viên hoàn thiện phương thức
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getParent() {
            return this.parent;
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }


    public void setRoot(E element) {
        if (n == 0) n++;
        root.element = element;
    }

    @Override
    public T root() {
        return (T) root.element;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<Node>();
        int counter = 1;
        while (counter <= (int) p) {
            Node removed = treeLevel.removeFirst();
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            } else {
                temp.add(removed.left);
                temp.add(removed.right);
            }
            if (treeLevel.isEmpty()) {
                treeLevel = temp;
                temp = new LinkedList<>();
            }
            counter++;
        }
        Node test = treeLevel.removeFirst();
        int count = 0;
        if (test.left != null) count++;
        if (test.right != null) count ++;
        return count++;
    }


    @Override
    public T parent(T p) {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<Node>();
        int counter = 1;
        while (counter <= (int) p) {
            Node removed = treeLevel.removeFirst();
            if (removed.left == null) removed.left = new Node<>(null, removed, null, null);
            if (removed.right == null) removed.right = new Node<>(null, removed, null, null);
            temp.add(removed.left);
            temp.add(removed.right);
            if (treeLevel.isEmpty()) {
                treeLevel = temp;
                temp = new LinkedList<>();
            }
            counter++;
        }
        Node test = treeLevel.removeFirst();
        return (T) test.parent.element;
    }

    @Override
    public T left(T p) {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<Node>();
        int counter = 1;
        while (counter <= (int) p) {
            Node removed = treeLevel.removeFirst();
            if (removed.left == null) removed.left = new Node<>(null, removed, null, null);
            if (removed.right == null) removed.right = new Node<>(null, removed, null, null);
            temp.add(removed.left);
            temp.add(removed.right);
            if (treeLevel.isEmpty()) {
                treeLevel = temp;
                temp = new LinkedList<>();
            }
            counter++;
        }
        Node test = treeLevel.removeFirst();
        if (test.left == null) return null;
        return (T) test.left.element;
    }

    @Override
    public T right(T p) {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<Node>();
        int counter = 1;
        while (counter <= (int) p) {
            Node removed = treeLevel.removeFirst();
            if (removed.left == null) removed.left = new Node<>(null, removed, null, null);
            if (removed.right == null) removed.right = new Node<>(null, removed, null, null);
            temp.add(removed.left);
            temp.add(removed.right);
            if (treeLevel.isEmpty()) {
                treeLevel = temp;
                temp = new LinkedList<>();
            }
            counter++;
        }
        Node test = treeLevel.removeFirst();
        if (test.right == null) return null;
        return (T) test.right.element;
    }

    @Override
    public T sibling(T p) {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<Node>();
        int counter = 0;
        while (counter < (int) p) {
            Node removed = treeLevel.removeFirst();
            if (removed.left == null) removed.left = new Node<>(null, removed, null, null);
            if (removed.right == null) removed.right = new Node<>(null, removed, null, null);
            temp.add(removed.left);
            temp.add(removed.right);
            if (treeLevel.isEmpty()) {
                treeLevel = temp;
                temp = new LinkedList<>();
            }
            counter++;
        }
        Node test = treeLevel.removeFirst();
        if (test == test.parent.right) return (T) test.parent.left.element;
        if (test == test.parent.left) return (T) test.parent.right.element;
        return null;
    }

    //update methods
    public Node<E> addRoot(E element) {
        // Add element to root of an empty tree
        if (n == 0) {
            root = new Node<>(element,null , null, null);
            n++;
            return root;
        } else return null;
    }

    public Node<E> addLeft(Node p, E element) {
        // Add element to left child node of p if empty
        if (p.left == null) {
            p.left = new Node<>(element, p, null ,null);
            n++;
            return p.left;
        } else return null;
    }

    public Node<E> addRight(Node p, E element) {
        // Add element to right child node of p if empty
        if (p.right == null) {
            p.right = new Node<>(element, p, null ,null);
            n++;
            return p.right;
        } else return null;
    }

    public void set(Node p, E element) {
        // set element to node p
        p.element = element;
    }

    public static void printBinaryTree(Node root)
    {
        LinkedList<Node> treeLevel = new LinkedList<Node>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<Node>();
        int counter = 0;
        int height = heightOfTree(root) - 1;
        // System.out.println(height);
        double numberOfElements
                = (Math.pow(2, (height + 1)) - 1);
        // System.out.println(numberOfElements);
        while (counter <= height) {
            Node removed = treeLevel.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements
                                / Math.pow(2, counter + 1),
                        removed);
            }
            else {
                printSpace(numberOfElements
                                / Math.pow(2, counter),
                        removed);
            }
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            }
            else {
                temp.add(removed.left);
                temp.add(removed.right);
            }

            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }

    public static void printSpace(double n, Node removed)
    {
        for (n /= 1.25; n > 0; n -= 2) {
            System.out.print("\t");
        }
        if (removed == null) {
            System.out.print(" ");
        }
        else {
            System.out.print(removed.element);
        }
    }

    public static int heightOfTree(Node root)
    {
        if (root == null) {
            return 0;
        }
        return 1
                + Math.max(heightOfTree(root.left),
                heightOfTree(root.right));
    }
}
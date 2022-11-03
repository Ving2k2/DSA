package Week5.ThucHanh;

import java.util.LinkedList;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree(){
        array = (E[]) new Object[defaultsize];
    }

    //update methods
    public void setRoot(E element) {
        array[1] = element;
        if (n == 0) n++;
    }

    public void setLeft(int p, E element) {
        // Set left child of p (at index 2p)
        int index = 2 * p;

        if (array[p] == null) {
            System.out.printf("Can not set child at %d, the parent not found", index);
        } else {
            array[index] = element;
            n++;
        }
    }

    public void setRight(int p, E element) {
        // Set right child of p (at index 2p+1)
        int index = (2 * p) + 1;

        if (array[p] == null) {
            System.out.printf("Can not set child at %d, the parent not found", index);
        } else {
            array[index] = element;
            n++;
        }
    }

    public E getRoot() {
        return array[1];
    }

    public E getVal(T e) {
        if (e != null) return array[(int) e];
        return null;
    }

    @Override
    public E root() {
        return array[1];
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
    public int numChildren(Object p) {int count = 0;
        if (right(p) != null) count++;
        if (left(p) != null) count++;
        return count;
    }

    @Override
    public T parent(Object p) {
        T result;
        if ((int) p % 2 == 0) result = (T) (Object) ((int) p/2);
        else result = (T) (Object) (((int) p - 1) /2);
        if ((int) result > 0) return result;
        return (T) (Object) 0;
    }

    @Override
    public T left(Object p) {
        int result = (int) p * 2;
        return (T) (Object) result;
    }

    @Override
    public T right(Object p) {
        int result = (int) p * 2 + 1;
        return (T) (Object) result;
    }

    @Override
    public T sibling(Object p) {
        T parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent)) return right(parent);
        if (p == right(parent)) return left(parent);
        return (T) (Object) 0;
    }

    public void printArrayTree(E root)
    {
        LinkedList<E> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        LinkedList<E> temp = new LinkedList<E>();
        int counter = 0;
        int height = heightOfTree(root);
        double numberOfElements
                = (Math.pow(2, (height + 1)) - 1);
        while (counter <= height) {
            E removed = treeLevel.removeFirst();
            int index = 0;
            if (removed == null) index = 0;
            else {
                for (int i = 1; i <= array.length; i++) {
                    if (array[i] == removed) {
                        index = i;
                        break;
                    }
                }
            }

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
            if (removed == null || 2 * index > array.length) {
                temp.add(null);
                temp.add(null);
            }
            else {
                temp.add(array[(int) this.left(index)]);
                temp.add(array[(int) this.right(index)]);
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

    public void printSpace(double n,  E removed)
    {

        for (n /= 1.25; n > 0; n -= 2) {
            System.out.print("\t");
        }
        if (removed != null) {
            System.out.print(removed);
        } else System.out.print(" ");
    }

    public int heightOfTree(E root)
    {
        if (root == null) return 0;
        int index = 0;
        for (int i = 1; i <= array.length; i++) {
            if (array[i] == root) {
                index = i;
                break;
            }
        }

        if (array[index] == null || 2 * index > array.length) {
            return 0;
        }

        return 1
                + Math.max(heightOfTree(array[(int) this.left(index)]),
                heightOfTree(array[(int) this.right(index)]));
    }



}

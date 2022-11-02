package Week5.ThucHanh;

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

    public void printTree() {
        for (int i = 1; i <= n + 1; i++) {
            if (array[i] == null) System.out.print("null ");
            else System.out.print(array[i] + " ");
        }
        System.out.println();
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
        return null;
    }

    @Override
    public T left(Object p) {
        int result = (int) p * 2;
        if (array[result] != null) return (T) (Object) result;
        return null;
    }

    @Override
    public T right(Object p) {
        int result = (int) p * 2 + 1;
        if (array[result] != null) return (T) (Object) result;
        return null;
    }

    @Override
    public T sibling(Object p) {
        T parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent)) return right(parent);
        if (p == right(parent)) return left(parent);
        return null;
    }
}

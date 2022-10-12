package Week4.ThucHanh;

public interface StackInterface<E> extends Iterable<E>{
    public void push(E element);
    public boolean isEmpty();
    public int size();
    public E pop();
    public E top();
}

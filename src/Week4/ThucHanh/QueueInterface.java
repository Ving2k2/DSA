package Week4.ThucHanh;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public E peek();
    public int size();
    public boolean isEmpty();

}

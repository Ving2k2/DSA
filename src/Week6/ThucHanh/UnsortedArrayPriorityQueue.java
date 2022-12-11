//package Week6.ThucHanh;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Objects;
//
//public class UnsortedArrayPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface{
//    protected class ArrEntry<K, E> implements Entry<K, E>{
//        K key;
//        E element;
//        public ArrEntry (K k, E e){
//            this.key = k;
//            this.element = e;
//        }
//
//        @Override
//        public K getKey() {
//            return this.key;
//        }
//
//        @Override
//        public E getValue() {
//            return this.element;
//        }
//    }
//
//    int n = 0;
//    int defaultsize = 1000;
//    ArrEntry<K, E>[] array = new ArrEntry[defaultsize];
//
//
//
//    @Override
//    public int size() {
//        return n;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return n == 0;
//    }
//
//    @Override
//    public void insert(Entry entry) {
//        if (n == defaultsize) {
//            System.out.println("The priority queue is full! can not insert " + entry);
//            return;
//        }
//        array[n++] = (ArrEntry<K, E>) entry;
//    }
//
//    @Override
//    public void insert(Object o, Object o2) {
//        if (n == defaultsize) {
//            System.out.println("The priority queue is full! can not insert ");
//            return;
//        }
//        array[n++] = new ArrEntry<>((K) o, (E) o2);
//    }
//
//    @Override
//    public Entry removeMin() {
//        Entry min = this.min();
//        for (int i = 0; i < n; i++) {
//            if (min == array[i]) {
//                Entry swap = array[i];
//                array[i] = array[n-1];
//                array[n-1] = (ArrEntry<K, E>) swap;
//            }
//        }
//        return array[--n];
//    }
//
//    @Override
//    public Entry min() {
//    }
//}

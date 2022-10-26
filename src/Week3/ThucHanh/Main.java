package Week3.ThucHanh;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>();
        simpleArrayList.add(1);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
        for (Object i : simpleArrayList) System.out.print(i +  " ");
        System.out.println();
        int i = 2;
        System.out.println("Object at index " + i + " is: " + simpleArrayList.get(2));
        simpleArrayList.remove(3);
        for (Integer integer : simpleArrayList) System.out.print(integer + " ");
        System.out.println();
        System.out.println("Size of array: " + simpleArrayList.size());
        System.out.println(simpleArrayList.isContain(2));
        System.out.println(simpleArrayList.isEmpty());
        simpleArrayList.set(1,3);
        for (Integer integer : simpleArrayList) System.out.print(integer + " ");
        System.out.println();


        ///////////////////////

        System.out.println();
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.addBot(3);
        list.printList();
        System.out.println("In index 1: " + list.get(1));
        list.remove(1);
        list.printList();
        list.set(0,4);
        list.printList();
        System.out.println("Remove " + list.removeBot() + " from list");
        list.printList();
        System.out.println(list.size());
        System.out.println(list.isContain(3));
        list.add(5);
        list.printList();
        System.out.println("Remove " + list.removeTop() + " from list");
        list.printList();
    }

}

package Week3.ThucHanh;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SimpleArrayList simpleArrayList = new SimpleArrayList<>();
        simpleArrayList.add(1);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
        for (Object i : simpleArrayList) System.out.print(i +  " ");
        System.out.println();
        int i = 2;
        System.out.println("Object at index " + i + " is: " + simpleArrayList.get(2));
        simpleArrayList.remove(3);
        Iterator inter = simpleArrayList.iterator();
        while (inter.hasNext()) System.out.print(inter.next() +  " ");
        System.out.println();
        System.out.println("Size of array: " + simpleArrayList.size());

        ///////////////////////

        System.out.println();
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.addBot(3);
        list.printList();
        list.remove(1);
        list.printList();
        System.out.println("Remove " + list.removeBot() + " from list");
        list.printList();
    }

}
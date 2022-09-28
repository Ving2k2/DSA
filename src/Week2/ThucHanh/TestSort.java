package Week2.ThucHanh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        List<MyCollection> collection = new ArrayList<>();
        Random rd = new Random();

        int length = rd.nextInt(1,10);
        int[] data = new int[length];
        for (int j = 0; j < length; j++) {
            data[j] = rd.nextInt(1,10);
        }


        for (int i = 0; i < 3; i++) {
            collection.add(new MyCollection(Arrays.copyOf(data,data.length)));
        }


        collection.get(0).setAlgorithm(new BubbleSort());
        collection.get(1).setAlgorithm(new SelectionSort());
        collection.get(2).setAlgorithm(new QuickSort());

        processCollectionsWithAl(collection);

    }



    public static void processCollectionsWithAl(List<MyCollection> myCollections) {
        for (MyCollection collection : myCollections) {
            System.out.println("------------");
            collection.performAl();
        }
        System.out.println();
        System.out.println("Done processing collection\n");
    }

}

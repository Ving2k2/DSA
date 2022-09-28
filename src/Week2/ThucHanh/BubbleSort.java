package Week2.ThucHanh;

public class BubbleSort implements SortAlgorithm {
    final double startTime = System.currentTimeMillis();

    int countSwap = 0;
    int countCompare = 0;

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }

        System.out.println("Staring Bubble Sort:");
        MyCollection.display(array);


        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    MyCollection.display(array);
                    countCompare++;
                    countSwap++;
                }
            }
        }

        System.out.println("-----------");
        System.out.println("Num of swap: " + getCountSwap());
        System.out.println("Num of comparing: " + getCountCompare());
        final double endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) / 1000);
        System.out.println();
        return array;
    }

    public int getCountSwap() {
        return countSwap;
    }

    public int getCountCompare() {
        return countCompare;
    }
}

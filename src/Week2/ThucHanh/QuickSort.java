package Week2.ThucHanh;

public class QuickSort implements SortAlgorithm{
    int countSwap = 0;
    int countCompare = 0;

    @Override
    public int[] sort(int[] arr) {
        final double startTime = System.currentTimeMillis();
        System.out.println("Staring Quick Sort:");
        MyCollection.display(arr);
        quickSort(arr,0, arr.length - 1);
        System.out.println("-----------");
        System.out.println("Num of swap: " + getCountSwap());
        System.out.println("Num of comparing: " + getCountCompare());
        final double endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) / 1000);
        System.out.println();
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        countSwap++;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            countCompare++;
        }
        swap(arr, i + 1, high);
        MyCollection.display(arr);
        return i + 1;
    }

    public void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr,pi + 1, high);
            countCompare++;
        } else {
            countCompare++;
        }
    }

    public int getCountSwap() {
        return countSwap;
    }

    public int getCountCompare() {
        return countCompare;
    }
}

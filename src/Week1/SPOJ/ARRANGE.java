package Week1.SPOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ARRANGE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();

        int numOfTest = Integer.parseInt(br.readLine());
        while (numOfTest-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer str = new StringTokenizer(br.readLine());
            int count = 0;

            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(str.nextToken());
                if (a[j] == 1) {
                    count++;
                    s.append(1).append(" ");
                }
            }
            quickSort(a,0, a.length - 1);

            if (n - count == 2 && a[n - 2] == 2 && a[n - 1] == 3) {
                s.append(2).append(" ").append(3);
            } else {
                for (int i = n - 1; i >= count; i--) {
                    s.append(a[i]).append(" ");
                }
            }
            s.append("\n");
        }
        out.print(s);
        br.close();
        out.close();
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr,pi + 1, high);
        }
    }
}



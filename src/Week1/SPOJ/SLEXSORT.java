package Week1.SPOJ;

import java.io.*;
import java.util.Arrays;

public class SLEXSORT {

    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();

        int numOfTest = Integer.parseInt(br.readLine());
        while (numOfTest-- > 0) {
            str = br.readLine();
            String[] words = new String[Integer.parseInt(br.readLine())];
            for (int i = 0; i < words.length; i++) {
                words[i] = br.readLine();
            }
            Arrays.sort(words, (str1, str2) -> {
                for (int i = 0; i < str1.length() && i < str2.length(); i++) {
                    if (str.indexOf(str1.charAt(i)) > str.indexOf(str2.charAt(i))) return 1;
                    if (str.indexOf(str1.charAt(i)) < str.indexOf(str2.charAt(i))) return -1;
                }
                return str1.length() - str2.length();
            });
            for (String word : words) {
                s.append(word).append("\n");
            }
            s.append("\n");
            br.readLine();
        }
        out.print(s);
        br.close();
        out.close();
    }}

//    static int compare(String str1, String str2) {
//        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
//            if (str.indexOf(str1.charAt(i)) > str.indexOf(str2.charAt(i))) return -1;
//            if (str.indexOf(str1.charAt(i)) < str.indexOf(str2.charAt(i))) return 1;
//        }
//        return str2.length() - str1.length();


//    static void swap(String[] arr, int i, int j) {
//        String temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    static int partition(String[] arr, String str, int low, int high) {
//        String pivot = arr[high];
//        int i= low - 1;
//        for (int j=low; j < high; j++) {
//            if (compare(str, arr[j], pivot) > 0) {
//                i++;
//                swap(arr, i, j);
//            }
//        }
//        swap(arr, i + 1, high);
//        return i + 1;
//    }
//
//    static void quickSort(String[] arr, String str, int low, int high) {
//        if (low < high) {
//            int pi = partition(arr, str, low, high);
//            quickSort(arr, str, low, pi - 1);
//            quickSort(arr, str,pi + 1, high);
//        }
//    }


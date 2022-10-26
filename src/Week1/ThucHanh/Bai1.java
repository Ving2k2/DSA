package Week1.ThucHanh;

import java.io.*;
import java.util.*;

public class Bai1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sPerfect = new StringBuilder();
        StringBuilder sPrime = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        //Arrays.setAll(a , i -> i);
        StringTokenizer str = new StringTokenizer(br.readLine());

        for (int j = 0; j < n; j++) {
            a[j] = Integer.parseInt(str.nextToken());
            if (isPerfect(a[j])) {
                sPerfect.append(a[j]).append(" ");
            } else if (isPrime(a[j])) {
                sPrime.append(a[j]).append(" ");
            }
        }
        sPrime.insert(0,"Dãy số nguyên tố là : ").append("\n");
        sPerfect.insert(0,"Dãy số hoàn hảo là là : ").append("\n");
        out.print(sPerfect);
        out.print(sPrime);
        br.close();
        out.close();
    }

    public static boolean isPerfect(int n) {
        int newNum = 0;
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                if (n % i == 0) newNum += i;
            }
            return newNum == n;
        }
        return false;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

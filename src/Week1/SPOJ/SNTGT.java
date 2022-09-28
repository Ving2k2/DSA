package Week1.SPOJ;

import java.util.Scanner;

public class SNTGT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTest = scanner.nextInt();
        while (numOfTest > 0) {
            int numTest = scanner.nextInt();
            if (isfactorial(numTest)) {
                System.out.println("YES");;
            } else {
                System.out.println("NO");
            }
            numOfTest--;
        }
        scanner.close();
    }

    public static boolean isfactorial(int n) {
        int[] factorial = {1, 2, 6, 24, 120, 720, 5040};
        for (int i = 0; i < factorial.length; i++){
            if (isPrime(n) && (factorial[i] == n || factorial[i] + 1 == n || factorial[i] - 1 == n)){
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

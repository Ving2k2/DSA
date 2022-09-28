package Week1.SPOJ;

import java.util.Scanner;

public class SNTFIBO_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTest = scanner.nextInt();
        for (int i = 0; i < numOfTest; i++) {
            if (isFibonacci(scanner.nextInt())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    // Chính phương
    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return (sqrt * sqrt == n);
    }

    // Fibonacci
    public static boolean isFibonacci(int n) {
        int temp = n * n * 5;
        return isPerfectSquare(temp + 4) || isPerfectSquare(temp - 4);
    }
}

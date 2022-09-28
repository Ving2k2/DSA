package Week1.SPOJ;

import java.util.Scanner;

public class SLPLN_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTest = scanner.nextInt();
        for (int i = 0; i < numOfTest; i++) {
            System.out.println((int) Math.cbrt(scanner.nextInt()));
        }
    }
}

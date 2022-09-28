package Week1.SPOJ;

import java.util.Scanner;

public class SLPLN_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTest = scanner.nextInt();
        double[] arrayOfCubed = {1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728,
                2197, 2744, 3375, 4096, 4913, 5832, 6859, 8000, 9261};
        while (numOfTest > 0) {
            int numTest = scanner.nextInt();
            for (int i = 0; i < arrayOfCubed.length; i++) {
                if (numTest == 1) {
                    System.out.println(1);
                    break;
                } else if (arrayOfCubed[i] > numTest && numTest < 9261) {
                    System.out.println((int) Math.cbrt(arrayOfCubed[i-1]));
                    break;
                } else if (numTest >= 9261) {
                    System.out.println((int) Math.cbrt(9261));
                    break;
                }
            }
            numOfTest--;
        }
    }
}

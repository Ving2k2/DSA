package Week1.ThucHanh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bai2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        boolean checkVal = true;
        while (checkVal) {
            System.out.println("Nhập 2 phân số: ");
            StringTokenizer str = new StringTokenizer(br.readLine());
            Fraction fraction1 = new Fraction(str.nextToken());
            Fraction fraction2 = new Fraction(str.nextToken());
            if (fraction1.getDenominator() != 0 && fraction2.getDenominator() != 0) checkVal = false;
            if (!checkVal) {
                fraction1.sum(fraction2);
                fraction1.min(fraction2);
                fraction1.pow(fraction2);
                fraction1.divide(fraction2);
            }
        }
    }
}

package Week1.ThucHanh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bai2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        int denominator1 = 0;
        int denominator2 = 0;
        int numerator1 = 1;
        int numerator2 = 1;

        boolean checkVal = true;
        while (checkVal) {
            System.out.println("Nhập 2 phân số: ");
            StringTokenizer str = new StringTokenizer(br.readLine());
            Fraction fraction1 = new Fraction(str.nextToken());
            Fraction fraction2 = new Fraction(str.nextToken());

            if (fraction1.getDenominator() != 0 && fraction2.getDenominator() != 0) checkVal = false;
        }



    }








}

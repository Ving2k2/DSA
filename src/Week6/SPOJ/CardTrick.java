package Week6.SPOJ;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CardTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        int numOfTest =  scanner.nextInt();
        while (numOfTest-- > 0) {
            int n = scanner.nextInt();
            int[] order = new int[n];
            int point = 0;
            int index,left,move,pos = 0;
            while (point++ < n) {
                index = pos;
                left = n - point + 1;
                move = point % left + 1;
                 for (int c = 0;;index++) {
                     if (index >= n) index = 0;
                     if (order[index] == 0) c++;
                     if (c == move) break;
                 }
                 pos = index;
                 order[index] = point;
            }
            Arrays.stream(order).forEach(i -> str.append(i).append(" "));
            str.append("\n");
        }
        out.print(str);
        out.close();
        scanner.close();
    }
}

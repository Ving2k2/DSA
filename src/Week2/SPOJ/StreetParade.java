package Week2.SPOJ;

import Week2.ThucHanh.SelectionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class StreetParade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();
        int numOfBus = Integer.parseInt(br.readLine());
        while (numOfBus > 0) {
            Stack<Integer> stack = new Stack<>();
            StringTokenizer str = new StringTokenizer(br.readLine());
            int count = 1;
            int i, car;
            for (i = 0; i < numOfBus; i++) {
                 car = Integer.parseInt(str.nextToken());

                 if (car == count) {
                     count++;
                     continue;
                 }

                while (!stack.empty() && count == stack.peek()) {
                    stack.pop();
                    count++;
                }

                 if (!stack.empty() && car > stack.peek()) break;
                 stack.push(car);
            }
            if (numOfBus == i) s.append("yes").append("\n");
            else s.append("no").append("\n");
            numOfBus = Integer.parseInt(br.readLine());
        }
        out.print(s);
        out.close();
        br.close();
    }
}
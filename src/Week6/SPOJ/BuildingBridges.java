package Week6.SPOJ;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BuildingBridges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        int numOfTest = scanner.nextInt();
        while (numOfTest-- > 0) {
            int numOfEndPoint = scanner.nextInt();
            int[][] Oxy = new int[numOfEndPoint][2];
            for (int i = 0; i < Oxy.length; i++) Oxy[i][0] = scanner.nextInt();
            for (int i = 0; i < Oxy.length; i++) Oxy[i][1] = scanner.nextInt();
            Arrays.sort(Oxy, (x1,x2) -> x1[0] == x2[0] ? 0 : x1[0] - x2[0]);
            str.append(bridges(Oxy)).append("\n");
        }
        out.print(str);
        scanner.close();
        out.close();
    }

    public static int bridges(int[][] arr) {
        int temp, count = 0;
        int Max_Bridges = 0;
        int i = -1;
        int index = 0;
        ArrayList<int[]> tmp = new ArrayList<>();
        while (i++ < arr.length && index < arr.length - 1) {
            temp = arr[index][1];
            if (arr[i][1] >= temp && i >= index) {
                count++;
                tmp.add(arr[i]);
            }

            if (i == arr.length - 1) {
                Max_Bridges = Math.max(count + minusBridges(tmp), Max_Bridges);
                count = 0;
                i = index;
                index++;
                tmp.clear();
            }
        }
        return Max_Bridges;
    }

    public static int minusBridges(ArrayList<int[]> arr) {
        int temp, count = 0;
        int Minus_Bridges = 0;
        int i = 0;
        int index = 0;
        while (i++ < arr.size() && index < arr.size() - 1) {
            temp = arr.get(index)[1];
            if (!(arr.get(i)[1] >= temp && i >= index)) {
                count--;
            }

            if (i == arr.size() - 1) {
                Minus_Bridges = Math.min(count, Minus_Bridges);
                count = 0;
                i = index;
                index++;
            }
        }
        return Minus_Bridges;
    }
}

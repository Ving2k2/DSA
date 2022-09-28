package Week1.SPOJ;

import java.io.*;

public class ACMNEW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfTest = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfTest; i++) {
            int[] team = new int[Integer.parseInt(br.readLine())];
            String[] strs = br.readLine().trim().split("\\s+");
            for (int j = 0; j < team.length; j++) {
                team[j] = Integer.parseInt(strs[j]);
            }

            bw.write(maxSumLimit(team, Integer.parseInt(br.readLine())) + "\n");
        }
        br.close();
        bw.close();
    }

    public static int maxSumLimit(int[] a, int lim) {
        int sumMax = - 1;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            sum += a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
                for (int m = j + 1; m < a.length; m++) {
                    sum += a[m];
                    if (sumMax <= sum && sum <= lim) sumMax = sum;
                    sum -= a[m];
                }
                sum -= a[j];
            }
        }
        return sumMax;
    }

}

package Week1.SPOJ;

import java.io.*;

public class SNTFIBO_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTest = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfTest; i++) {
            if (isFibonacci(Integer.parseInt(br.readLine()))) {
                bw.write("YES\n");
                bw.flush();
            } else {
                bw.write("NO\n");
                bw.flush();
            }
        }
        br.close();
        bw.close();
    }

    // Fibonacci
    public static boolean isFibonacci(int n) {
        int a = 0;
        int b = 1;
        if (n == a || n == b) return true;
        int c = a + b;
        while(c <= n)
        {
            if(c == n) return true;
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }
}

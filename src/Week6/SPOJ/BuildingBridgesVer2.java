package Week6.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class BuildingBridgesVer2 {
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader(System.in);
        StringBuilder str = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        int numOfTest = scanner.nextInt();
        while (numOfTest-- > 0) {
            int numOfEndPoint = scanner.nextInt();
            int[][] Oxy = new int[numOfEndPoint][2];
            for (int i = 0; i < Oxy.length; i++) Oxy[i][0] = scanner.nextInt();
            for (int i = 0; i < Oxy.length; i++) Oxy[i][1] = scanner.nextInt();
            Arrays.sort(Oxy, (x1,x2) -> x1[0] == x2[0] ? x1[1] - x2[1] : x1[0] - x2[0]);
            str.append(bridges(Oxy, Oxy.length)).append("\n");
        }
        out.print(str);
        scanner.close();
        out.close();
    }

    public static int bridges(int[][] arr, int n) {
        int[] lis = new int[n];
        int i, j, max = 0;

        Arrays.fill(lis,1);

        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i][1] >= arr[j][1] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        return Arrays.stream(lis).max().getAsInt();
    }

    static class Reader {
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader(InputStream in) {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        final private int BUFFER_SIZE = 1 << 16;

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}


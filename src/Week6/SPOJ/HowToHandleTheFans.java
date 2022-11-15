package Week6.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HowToHandleTheFans {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();
        StringTokenizer str = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(str.nextToken());
        int Q = Integer.parseInt(str.nextToken());
        int[] office = new int[4 * N];
        Arrays.setAll(office, i -> 0);
        while (Q-- > 0) {
            str = new StringTokenizer(reader.readLine());
            if (str.nextToken().equals("find")) {
                int numStart = Integer.parseInt(str.nextToken());
                int numEnd = Integer.parseInt(str.nextToken());
                int sum =find(office, 0, 1, N, numStart, numEnd);
                s.append(sum).append("\n");
            } else {
                int position = Integer.parseInt(str.nextToken());
                int numOfFan = Integer.parseInt(str.nextToken());
                add(office, 0, 1, N, position, numOfFan);
            }
        }
        out.print(s);
        out.close();
        reader.close();
    }

    public static void add(int[] a,int id, int l, int r, int i, int v) {
        if (i < l || i > r) return;
        if (l == r) {
            a[id] += v;
            return;
        }
        int mid = (l + r) / 2;
        add(a, id * 2 + 1, l, mid, i, v);
        add(a, id * 2 + 2, mid + 1, r, i, v);

        a[id] = a[id * 2 + 1] + a[id * 2 + 2];
    }

    public static int find(int[] a, int id, int l, int r, int u, int v) {
        if (l > v || r < u) return 0;
        if (l >= u && v >= r) return a[id];
        int mid = (l + r) / 2;
        return find(a, id * 2 + 1, l, mid, u, v) +
                find(a, id * 2 + 2, mid + 1, r, u, v);
    }

    static class Reader {
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader() {
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

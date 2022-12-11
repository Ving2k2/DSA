package Week7.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class ConnectedCountry {
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader(System.in);
        StringBuilder str = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        int numOfCity = scanner.nextInt();
        int numOfRoad = scanner.nextInt();

        parent = new int[numOfCity];
        Arrays.setAll(parent, i -> i);

        size = new int[numOfCity];
        Arrays.fill(size, 1);

        while (numOfRoad-- > 0) {
            int cityX = scanner.nextInt();
            int cityY = scanner.nextInt();
            join(cityX, cityY);
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : parent) set.add(find_root(i));

        str.append(set.size() - 1).append("\n");
        out.print(str);
        out.close();
        scanner.close();
    }

    public static int find_root(int v) {
        return v == parent[v] ? v : (parent[v] = find_root(parent[v]));
    }

    public static void join(int u, int v) {
        u = find_root(u);
        v = find_root(v);
        if (u != v) {
            if (size[u] < size[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            parent[v] = u;
            size[u] += size[v];
        }
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



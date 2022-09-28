package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SocialNetworkCommunity {
    static int[] parent, size;
    static int sizeOfCommunity;
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();

        int numOfUser = reader.nextInt();
        sizeOfCommunity = reader.nextInt();
        parent = new int[numOfUser + 1];
        Arrays.setAll(parent, p -> p > numOfUser + 1 ? 0 : p);
        size = new int[numOfUser + 1];
        Arrays.fill(size, 1);

        int numOfQueries = reader.nextInt();
        String code;
        int a;
        int b = 0;
        while (numOfQueries-- > 0) {
            String queue = reader.readLine();
            StringTokenizer str = new StringTokenizer(queue);
            code = str.nextToken();
            a = Integer.parseInt(str.nextToken());
            if (str.hasMoreTokens()) b = Integer.parseInt(str.nextToken());
            switch (code) {
                case "S" :
                    s.append(size[find(a)]).append("\n");
                    break;
                case "A" :
                    union(a, b);
                    break;
                case "E" :
                    s.append(checkConnect(a, b)).append("\n");
                    break;
            }

        }
        out.print(s);
        out.close();
        reader.close();
    }

    static int find(int a) {
        if (parent[a] != a) return find(parent[a]);
        return a;
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (size[rootA] + size[rootB] <=sizeOfCommunity) {
            if (size[rootA] < size[rootB]) {
                parent[rootA] = parent[rootB];
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = parent[rootA];
                size[rootA] += size[rootB];
            }
        }
    }

    static String checkConnect(int a, int b) {
        if (find(a) == find(b)) return "Yes";
        return "No";
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}

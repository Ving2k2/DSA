package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AdaAndQueue {
    public static void main(String[] args) throws IOException {
        SocialNetworkCommunity.Reader reader = new SocialNetworkCommunity.Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();

        int numOfUser = reader.nextInt();
        int sizeOfCommunity = reader.nextInt();
        int[] parent = new int[numOfUser + 1];
        Arrays.setAll(parent, p -> p);
        int[] size = new int[numOfUser + 1];
        Arrays.fill(size, 1);

        int numOfQueries = reader.nextInt();
        String code;
        int a;
        int b = 0;
        while (numOfQueries-- > 0) {

        }
        out.print(s);
        out.close();
        reader.close();
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
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

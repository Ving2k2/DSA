package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AdaAndQueue {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();

        int numOfQueries = reader.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String code;
        int a = 0;
        boolean r = false;
        while (numOfQueries-- > 0) {
            StringTokenizer str = new StringTokenizer(reader.readLine());
            code = str.nextToken();
            if (str.hasMoreTokens()) a = Integer.parseInt(str.nextToken());
            switch (code) {
                case "toFront":
                    if (r) queue.offer(a);
                    else queue.offerFirst(a);
                    break;
                case "push_back":
                    if (!r) queue.offer(a);
                    else queue.offerFirst(a);
                    break;
                case "back":
                    if (queue.isEmpty()) s.append("No job for Ada?").append("\n");
                    else s.append(r ? queue.pollFirst() : queue.pollLast()).append("\n");
                    break;
                case "front":
                    if (queue.isEmpty()) s.append("No job for Ada?").append("\n");
                    else s.append(r ? queue.pollLast() : queue.pollFirst()).append("\n");
                    break;
                case "reverse":
                    r = !r;
                    break;
            }
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

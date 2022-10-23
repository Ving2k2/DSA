package Week2.SPOJ;

import java.io.*;
import java.util.*;

public class RMID2 {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();

        int numOftest = reader.nextInt();
        while (numOftest-- > 0) {
            MedianQueue queue = new MedianQueue();
            int num = reader.nextInt();
            while (num != 0) {
                if (num != -1) {
                    queue.add(num);
                } else if (queue.size() > 0) {
                    s.append(queue.remove()).append("\n");
                }
                num = reader.nextInt();
            }
        }
        out.print(s);
        out.close();
        reader.close();
    }

    public static class MedianQueue {
        PriorityQueue<Integer> right, left;

        public MedianQueue() {
            right = new PriorityQueue<>();
            left = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void add(int num) {
            if (!right.isEmpty() && num > right.peek()) {
                right.add(num);
                if (right.size() - left.size() > 1) {
                    left.add(right.remove());
                }
            }
            else {
                left.add(num);
                if (left.size() - right.size() > 1) {
                    right.add(left.remove());
                }
            }
        }

        public int size() {
            return left.size() + right.size();
        }

        public int remove() {
            return right.size() > left.size() ? right.remove() : left.remove();
        }
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

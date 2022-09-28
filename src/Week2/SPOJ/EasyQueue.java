package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class EasyQueue {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        int numOfQueries = reader.nextInt();
        int code;
        while (numOfQueries-- > 0) {
            code = reader.nextInt();
            if (code == 1) {
                queue.offer(reader.nextInt());
            } else if (code == 2) {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            } else if (code == 3) {
                s.append(queue.isEmpty() ? "Empty!" : queue.peek()).append("\n");
            }
        }
        out.print(s);
        out.flush();
        out.close();
        reader.close();
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

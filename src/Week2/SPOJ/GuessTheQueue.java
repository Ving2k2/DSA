package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GuessTheQueue {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuffer s = new StringBuffer();
        int numOfTest = reader.nextInt();
        int numOfOperations;
        int count = 0, y;
        String x, code;
        while (count++ < numOfTest) {
            s.append("Case ").append(count).append(":\n");
            ArrayList<Integer> queue = new ArrayList<>();
            numOfOperations = reader.nextInt();
            while (numOfOperations-- > 0) {
                StringTokenizer token = new StringTokenizer(reader.readLine());
                code = token.nextToken();
                switch (code) {
                    case "1":
                        x = token.nextToken();
                        y = Integer.parseInt(token.nextToken());
                        if (x.equals("B")) queue.add(y);
                        else queue.add(0, y);
                        break;
                    case "2":
                        x = token.nextToken();
                        if (x.equals("B")) queue.remove(queue.size() - 1);
                        else queue.remove(0);
                        break;
                    case "3":
                        x = token.nextToken();
                        y = Integer.parseInt(token.nextToken());
                        if (x.equals("D")) s.append(queue.get(y - 1)).append("\n");
                        else s.append(queue.indexOf(y)).append(1).append("\n");
                        break;
                }
            }
        }

        out.print(s);
        out.close();
        reader.close();
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

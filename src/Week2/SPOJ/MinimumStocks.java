package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumStocks {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        int day = reader.nextInt();
        int code, price;
        int count = 0;
        String stock;
        while (day-- > 0) {
            count++;
            StringTokenizer instruction = new StringTokenizer(reader.readLine());
            code = Integer.parseInt(instruction.nextToken());
            switch (code) {
                case 1:
                    stock = instruction.nextToken();
                    price = Integer.parseInt(instruction.nextToken());
                    map.put(stock, price);
                    queue.add(stock);
                    break;
                case 2:
                    stock = instruction.nextToken();
                    price = Integer.parseInt(instruction.nextToken());
                    map.put(stock, price);
                    if (!queue.isEmpty()) {
                        String finalStock = stock;
                        queue.removeIf(p -> p.equals(finalStock));
                        queue.add(finalStock);
                    }
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        s.append(queue.peek()).append(" ").append(count).append("\n");
                        map.remove(queue.poll());
                    }
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

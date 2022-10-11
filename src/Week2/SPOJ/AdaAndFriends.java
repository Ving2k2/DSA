package Week2.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AdaAndFriends {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();
        HashMap<String, Long> map = new HashMap<>();
        Set<String> queue = new HashSet<>();
        int numOfCel = reader.nextInt();
        int maxUnfriend = reader.nextInt();
        String name;
        Long money, sum;
        while (numOfCel-- > 0) {
            StringTokenizer str = new StringTokenizer(reader.readLine());
            name = str.nextToken();
            money = Long.valueOf(str.nextToken());
            if(map.containsKey(name)) money += map.get(name);
            map.put(name, money);
            queue.add(name);
        }
        if (queue.size() <= maxUnfriend) sum = map.values().stream().reduce(0L, Long::sum);
        else sum = queue.stream().sorted(Collections.reverseOrder(Comparator.comparingLong(map::get))).limit(maxUnfriend)
                    .mapToLong(map::get).sum();
        s.append(sum);
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


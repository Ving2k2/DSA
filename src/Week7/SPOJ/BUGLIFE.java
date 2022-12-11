package Week7.SPOJ;

import java.io.*;
import java.util.*;

public class BUGLIFE {
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        StringBuilder str = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        int numTest = scanner.nextInt();
        int count = 0;
        while (++count <= numTest) {
            int numOfBugs = scanner.nextInt();
            int numOfAction = scanner.nextInt();
            int[] gender = new int[numOfBugs + 1];
            int[][] relate = new int[numOfAction][2];
            Arrays.fill(gender, -1);
            while (--numOfAction >= 0) {
                relate[numOfAction][0] = scanner.nextInt();
                relate[numOfAction][1] = scanner.nextInt();
            }
            if (!checkHomo(relate, gender, 1)) str.append("Scenario #").append(count).append(":\n").append("Suspicious bugs found!\n");
            else str.append("Scenario #").append(count).append(":\n").append("No suspicious bugs found!\n");
        }
        out.print(str);
        out.close();
        scanner.close();
    }

    public static boolean checkHomo(int[][] relate, int[] gender, int start) {
       LinkedList<Integer> queue = new LinkedList<>();
       gender[start] = 1;
       queue.add(start);

       while (!queue.isEmpty()) {
           int u = queue.poll();
           for (int i = 0; i < relate.length; i++) {
               for (int j = 0; j < relate[0].length; j++) {
                   if (relate[i][j] == u && gender[relate[i][1 - j]] == -1) {
                       gender[relate[i][1 - j]] = 1 - gender[u];
                       queue.add(relate[i][1 - j]);
                   } else if (relate[i][j] == u && gender[relate[i][1 - j]] == gender[u]) return false;
               }
           }

           for (int i = 1; i < gender.length; i++) {
               if (gender[i] == -1) {
                   queue.add(i);
                   break;
               }
           }
       }
       return true;
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


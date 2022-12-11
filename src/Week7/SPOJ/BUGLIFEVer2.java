package Week7.SPOJ;

import java.io.*;
import java.util.*;

public class BUGLIFEVer2 {
    private static int[] gender;
    private static ArrayList<Integer>[] relate;
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        StringBuilder str = new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        int numTest = scanner.nextInt();
        int count = 0;
        while (++count <= numTest) {
            boolean errHomo = false;
            int numOfBugs = scanner.nextInt();
            relate = new ArrayList[numOfBugs];
            int numOfAction = scanner.nextInt();
            for (int i = 0; i < numOfBugs; i++) relate[i] = new ArrayList<Integer>();

            gender = new int[numOfBugs];
            Arrays.fill(gender, -1);

            while (--numOfAction >= 0) {
                int bug1 = scanner.nextInt() - 1;
                int bug2 = scanner.nextInt() - 1;
                relate[bug1].add(bug2);
                relate[bug2].add(bug1);
            }

            for (int i = 0; i < numOfBugs; i++) {
                if (gender[i] == -1 && checkHomoErr(i, 1)) errHomo = true;
            }

            if (errHomo) str.append("Scenario #").append(count).append(":\n").append("Suspicious bugs found!\n");
            else str.append("Scenario #").append(count).append(":\n").append("No suspicious bugs found!\n");
        }
        out.print(str);
        out.close();
        scanner.close();
    }

    public static boolean checkHomoErr(int bug, int love) {
       if (gender[bug] != -1) return gender[bug] != love;
       int nLove = 1 - love;
       gender[bug] = love;
       for (int bugs : relate[bug]) {
           if (checkHomoErr(bugs, nLove)) return true;
       }
       return false;
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


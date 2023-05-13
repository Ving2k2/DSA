package Week7.SPOJ;

import java.io.*;

public class AirCombat {
    static int[][][] bit;
    static int gapX, gapY, gapZ;

    public static void main(String[] args) throws IOException {
        Reader br = new Reader(System.in);
        String[] line = br.readLine().split(" ");
        int numTests = Integer.parseInt(line[0]);
        while (numTests-- > 0) {
            line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int z1 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            int y2 = Integer.parseInt(line[4]);
            int z2 = Integer.parseInt(line[5]);
            gapX = x2 - x1 + 1;
            gapY = y2 - y1 + 1;
            gapZ = z2 - z1 + 1;
            bit = new int[gapX + 1][gapY + 1][gapZ + 1];
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                line = br.readLine().split(" ");
                char q = line[0].charAt(0);
                int x3 = Integer.parseInt(line[1]) - x1 + 1;
                int y3 = Integer.parseInt(line[2]) - y1 + 1;
                int z3 = Integer.parseInt(line[3]) - z1 + 1;
                if (q == 85) update(x3, y3, z3, Integer.parseInt(line[4]));
                else {
                    if (get(x3, y3, z3)) System.out.println("Friend");
                    else System.out.println("Enemy");
                }
            }
        }
        br.close();
    }

    static void update(int x, int y, int z, int r) {
        int xa = Math.max(x - r, 1);
        int xb = x + r + 1;
        int ya = Math.max(y - r, 1);
        int yb = y + r + 1;
        int za = Math.max(z - r, 1);
        int zb = z + r + 1;
        update(xb,yb,zb);
        update(xa,ya,za);
        update(xb,ya,za);
        update(xa,yb,za);
        update(xa,ya,zb);
        update(xb,yb,za);
        update(xb,ya,zb);
        update(xa,yb,zb);
    }

    static void update(int x, int y, int z) {
        for (int i = x; i <= gapX; i += i & -i)
            for (int j = y; j <= gapY; j += j & -j)
                for (int k = z; k <= gapZ; k += k & -k)
                    bit[i][j][k] ^= 1;
    }

    static boolean get(int x, int y, int z) {
        int res = 0;
        for (int i = x; i > 0; i -= i & -i)
            for (int j = y; j > 0; j -= j & -j)
                for (int k = z; k > 0; k -= k & -k)
                    res ^= bit[i][j][k];
        return res != 0;
    }

    static class Reader {
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader(InputStream in) {
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
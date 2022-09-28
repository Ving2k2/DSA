package Week2.SPOJ;

import java.io.*;
import java.util.Stack;

public class EasyStack {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int numOfQueries = reader.nextInt();
        int code, num;
        while (numOfQueries-- > 0) {
            code = reader.nextInt();

            if (code == 1) {
                num = reader.nextInt();
                stack.push(num);
            } else if (code == 2) {
                if (!stack.empty()) stack.pop();
            } else if (code == 3) {
                if (!stack.empty()) s.append(stack.peek()).append("\n");
                else s.append("Empty!\n");
            }

            /* switch - case :
            switch (code) {
                case 1:
                    stack.push(reader.nextInt());
                    break;
                case 2:
                    if (!stack.empty()) stack.pop();
                    break;
                case 3:
                    if (!stack.empty()) s.append(stack.peek()).append("\n");
                    else s.append("Empty!\n");
                    break;
                default:
                	break;
            } */

        }
        out.print(s);
        out.close();
        reader.close();
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
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
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
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

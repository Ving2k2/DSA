package Week7.SPOJ;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class StoppingOffCity {
    public static Vector<int[]>[] graph;
    public static Stack<HashSet<Integer>> components = new Stack<>();
    public static int time;
    public static int[] graphWeighted;
    public static int[] path, low, number;
    public static boolean[] visited;
    public static StringBuilder str = new StringBuilder();
    public static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        int numOfCity = scanner.nextInt();
        graph = new Vector[numOfCity];
        graphWeighted = new int[numOfCity];
        path = new int[numOfCity];

        for (int i = 0; i < numOfCity; i++) {
            graph[i] = new Vector<>();
        }
        while (true) {
            int cityX = scanner.nextInt();
            int cityY = scanner.nextInt();
            if (cityY == -1 && cityX == -1) break;
            graph[cityX].add(new int[]{cityY, 1});
            graph[cityY].add(new int[]{cityX, 1});
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        getBiConnectedComponents(numOfCity);
        dijkstra(start, end);
        drawn(end, numOfCity);
        scanner.close();
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(i -> i[1]));
        Arrays.fill(graphWeighted, Integer.MAX_VALUE);
        graphWeighted[start] = 0;
        queue.add(new int[]{start, 0});
        path[start] = -1;
        while (!queue.isEmpty()) {
            int u = queue.peek()[0];
            int du = queue.poll()[1];
            if (du != graphWeighted[u]) continue;

            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u].get(i)[0];
                int dv = graph[u].get(i)[1];
                if (graphWeighted[v] > graphWeighted[u] + dv) {
                    graphWeighted[v] = graphWeighted[u] + dv;
                    path[v] = u;
                    if (v == end) break;
                    queue.add(new int[]{v, graphWeighted[v]});
                }
            }
        }
    }

    public static void drawn(int end, int n) {
        ArrayList<Integer> way = new ArrayList<>();
        while (end != -1) {
            way.add(end);
            end = path[end];
        }
        SortedSet<Integer> result = new TreeSet<>();
        for (HashSet<Integer> b : components) {
            int x = 0;
            for (Integer integer : way) {
                if (b.contains(integer)) {
                    x++;
                }
                if (x == 2) {
                    result.addAll(b);
                    break;
                }
            }
        }
        result.forEach(i -> str.append(i).append(" "));
        str.append("\n");
        out.print(str);
        out.close();
    }

    public static void getBiConnectedComponents(int n) {
        time = 1;
        low = new int[n];
        number = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Stack<int[]> stack = new Stack<>();
                DFS(i, stack);
                components.add(new HashSet<>());
                while (stack.size() != 0) {
                    components.peek().add(stack.peek()[0]);
                    components.peek().add(stack.peek()[1]);
                    stack.pop();
                }
            }
        }
    }
    public static void DFS(int start, Stack<int[]> stack) {
        number[start] = low[start] = time++;
        visited[start] = true;
        int child = 0;
        for (int[] a : graph[start]) {
            int v = a[0];
            int[] edge = new int[]{start, v};
            if (!visited[v]) {
                child++;
                stack.push(edge);
                path[v] = start;
                DFS(v, stack);
                low[start] = Math.min(low[v], low[start]);
                if ((path[start] != -1 && low[v] >= number[start]) || (path[start] == -1 && child > 1)) {
                    components.push(new HashSet<>());
                    while (stack.size() != 0) {
                        components.peek().add(stack.peek()[0]);
                        components.peek().add(stack.peek()[1]);
                        if (stack.peek()[0] == edge[0] && stack.peek()[1] == edge[1]) {
                            stack.pop();
                            break;
                        }
                        stack.pop();
                    }
            }
            } else if (path[start] != v && number[v] < low[start]) {
                low[start] = number[v];
                stack.push(edge);
            }
        }
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


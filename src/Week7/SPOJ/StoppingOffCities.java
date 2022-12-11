package Week7.SPOJ;


import java.io.*;
import java.util.*;

public class StoppingOffCities {
    private static Vector<int[]>[] graph;
    private static Stack<HashSet<Integer>> components;
    private static boolean[] visited;
    private static int[] d;
    private static int[] path;
    private static int[] parent;
    private static int[] num;
    private static int[] low;
    private static int count;

    public static void getBiConnectedComponents(int n) {
        count = 1;
        low = new int[n];
        visited = new boolean[n];
        num = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Stack<int[]> stack = new Stack<>();
                dfs(i, stack);
                components.add(new HashSet<>());
                while (stack.size() != 0) {
                    components.peek().add(stack.peek()[0]);
                    components.peek().add(stack.peek()[1]);
                    stack.pop();
                }
            }
        }
    }

    public static void dfs(int u, Stack<int[]> stack) {
        num[u] = low[u] = count++;
        visited[u] = true;

        int child = 0;
        for (int[] a : graph[u]) {
            int v = a[0];
            int[] edge = new int[]{u, v};
            if (!visited[v]) {
                child++;
                parent[v] = u;
                stack.push(edge);
                dfs(v, stack);
                low[u] = Math.min(low[u], low[v]);

                if ((parent[u] == -1 && child > 1) || (parent[u] != -1 && low[v] >= num[u])) {
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
            } else if (parent[u] != v && num[v] < low[u]) {
                low[u] = num[v];
                stack.push(edge);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int numCities = nextInt();
        graph = new Vector[numCities];
        visited = new boolean[numCities];
        d = new int[numCities];
        path = new int[numCities];
        components = new Stack<>();
        for (int i = 0; i < numCities; i++) {
            graph[i] = new Vector<>();
        }

        int v1, v2;
        while (true) {
            v1 = nextInt();
            v2 = nextInt();
            if (v1 == -1) {
                break;
            }
            graph[v1].add(new int[]{v2, 1});
            graph[v2].add(new int[]{v1, 1});
        }
        int s = nextInt();
        int d = nextInt();
        getBiConnectedComponents(numCities);
        dijkstra(s);

        int[] way = new int[numCities];
        count = 0;
        while (d != -1) {
            way[count++] = d;
            d = path[d];
        }

        visited = new boolean[numCities];
        SortedSet<Integer> result = new TreeSet<>();
        for (HashSet<Integer> b : components) {
            int x = 0;
            for (int j = 0; j < count; j++) {
                if (b.contains(way[j])) {
                    x++;
                }
                if (x >= 2) {
                    break;
                }
            }
            if (x == 2) {
                result.addAll(b);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int e : result) {
            sb.append(e).append(' ');
        }
        sb.append('\n');
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    public static void dijkstra(int s) {
        Queue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        pq.add(new Integer[]{s, 0});
        path[s] = -1;
        while (!pq.isEmpty()) {
            int u = pq.peek()[0];
            int du = pq.poll()[1];

            if (du != d[u]) {
                continue;
            }

            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u].get(i)[0];
                int dv = graph[u].get(i)[1];
                if (d[v] > d[u] + dv) {
                    d[v] = d[u] + dv;
                    pq.add(new Integer[]{v, d[v]});
                    path[v] = u;
                }
            }
        }
    }

    //-------------Reader---------------------
    private static final InputStream INPUT_STREAM = System.in;
    private static final byte[] inBuf = new byte[1024];
    private static int lenBuf = 0;
    private static int ptrBuf = 0;

    private static int readByte() {
        if (lenBuf == -1) throw new InputMismatchException();

        if (ptrBuf >= lenBuf) {
            ptrBuf = 0;
            try {
                lenBuf = INPUT_STREAM.read(inBuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        if (lenBuf <= 0) return -1;

        return inBuf[ptrBuf++];
    }

    public static int nextInt() {
        int num = 0;
        int b;

        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') num = (num << 3) + (num << 1) + (b - '0');
            else return minus ? -num : num;
            b = readByte();
        }
    }

    public static String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    public static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }
}
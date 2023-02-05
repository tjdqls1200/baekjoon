import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 작은 번호부터 방문, 양방향 간선(방문 체크)\
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][n + 1];
        ch = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        DFS(v);
        Arrays.fill(ch, false);
        sb.append("\n");
        BFS(v);
        System.out.println(sb.toString());
    }

    private static void DFS(int from) {
        ch[from] = true;
        sb.append(from).append(" ");

        for (int to = 1; to <= n; to++) {
            // from -> to 이동 가능하고, 방문 체크가 안 된 경우
            if (map[from][to] && !ch[to]) {
                DFS(to);
            }
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        move(queue, v);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to = 1; to <= n; to++) {
                if (map[from][to] && !ch[to]) {
                    move(queue, to);
                }
            }
        }
    }

    private static void move(Queue<Integer> queue, int to) {
        sb.append(to).append(" ");
        ch[to] = true;
        queue.offer(to);
    }
}

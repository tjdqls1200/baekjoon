import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int M, N;
    static int[] dn = {0, 0, 1, -1};
    static int[] dm = {-1, 1, 0, 0};
    static Queue<Pos> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // M : 가로 N : 세로
        // for day++, bfs

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                // 익은 토마토 queue에 넣어두기
                if (n == 1) {
                    queue.offer(new Pos(i, j));
                }
                map[i][j] = n;
            }
        }

        boolean isChecked = false;
        int day = 0;
        while (!isChecked) {
            if (BFS()) {
                day++;
            }
            if (queue.isEmpty()) {
                // 토마토가 전부 익었을 때, 익지 않은 토마토(사각 지대)가 있으면 -1
                if (!mapCheck()) {
                    day = -1;
                }
                isChecked = true;
            }
        }
        System.out.println(day);
    }

    // 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 빈칸
    private static boolean BFS() {
        int len = queue.size();
        boolean changed = false;
        int mn, mm;

        for (int l = 0; l < len; l++) {
            Pos pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                mn = pos.n + dn[i];
                mm = pos.m + dm[i];
                // 범위 벗어나면 continue
                if ((mn < 0 || mn >= N) || (mm < 0 || mm >= M)) {
                    continue;
                }
                // 안 익은 토마토일 경우
                if (map[mn][mm] == 0) {
                    changed = true;
                    map[mn][mm] = 1;
                    queue.offer(new Pos(mn, mm));
                }
            }
        }
        return changed;
    }

    private static class Pos {
        int n;
        int m;

        public Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    private static boolean mapCheck() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        return false;
                    }
                }
            }
        return true;
    }
}

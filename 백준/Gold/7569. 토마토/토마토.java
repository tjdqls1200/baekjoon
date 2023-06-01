import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;
    static boolean[][][] ch;
    static int M, N, H;
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dn = {0, 0, 0, 0, 1, -1};
    static int[] dm = {0, 0, -1, 1, 0, 0};
    static Queue<Pos> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // M : 가로 N : 세로 H : 높이
        // for day++, bfs

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        ch = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 1) {
                        queue.offer(new Pos(i, j, k));
                        ch[i][j][k] = true;
                    }
                    map[i][j][k] = n;
                }
            }
        }

        boolean isChecked = false;
        int day = 0;
        while (!isChecked) {
            if (BFS()) {
                day++;
            }
            if (queue.isEmpty()) {
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

        for (int l = 0; l < len; l++) {
            Pos pos = queue.poll();
            for (int i = 0; i < 6; i++) {
                int mh = pos.h + dh[i];
                int mn = pos.n + dn[i];
                int mm = pos.m + dm[i];
                // 범위 벗어나면 continue
                if ((mh < 0 || mh >= H) || (mn < 0 || mn >= N) || (mm < 0 || mm >= M)) {
                    continue;
                }
                // 안 익은 토마토인지, 같은 날 익은 토마토인지 체크
               if ((map[mh][mn][mm] == 0) && !ch[mh][mn][mm]) {
                    changed = true;
                    map[mh][mn][mm] = 1;
                    ch[mh][mn][mm] = true;
                    queue.offer(new Pos(mh, mn, mm));
                }
            }
        }
        return changed;
    }

    private static class Pos {
        int h;
        int n;
        int m;

        public Pos(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }

    private static boolean mapCheck() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

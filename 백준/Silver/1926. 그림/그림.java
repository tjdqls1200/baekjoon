import java.util.*;
import java.io.*;

class Main {
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] ch;
    static int maxY;
    static int maxX;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxY = Integer.parseInt(st.nextToken());
        maxX = Integer.parseInt(st.nextToken());

        map = new int[maxY][maxX];

        for (int y = 0; y < maxY; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < maxX; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        ch = new boolean[maxY][maxX];

        int maxWidth = 0;
        int count = 0;

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (map[y][x] == 1 && !ch[y][x]) {
                    ++count;
                    ch[y][x] = true;
                    maxWidth = Math.max(maxWidth, bfs(new Pos(y, x)));
                }
            }
        }
        System.out.println(count);
        System.out.println(maxWidth);
    }

    private static int bfs(Pos start) {
        Queue<Pos> q = new LinkedList<>();
        int n = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int my = pos.y + dy[i];
                int mx = pos.x + dx[i];

                if (my < 0 || my == maxY || mx < 0 || mx == maxX) {
                    continue;
                }
                if (map[my][mx] == 0 || ch[my][mx]) {
                    continue;
                }

                ch[my][mx] = true;
                q.offer(new Pos(my, mx));
                ++n;
            }
        }

        return n;
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
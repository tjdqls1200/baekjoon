import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static char[][] map;
    static int n;
    static boolean[][] ch;
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            for (int x = 0; x < n; x++) {
                map[y][x] = line.charAt(x);
            }
        }


        int colorA = 0;
        int colorB = 0;

        ch = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!ch[y][x]) {
                    ch[y][x] = true;
                    bfs(new Point(y, x), map[y][x]);
                    ++colorA;
                }
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 'R') {
                    map[y][x] = 'G';
                }
            }
        }

        ch = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!ch[y][x]) {
                    ch[y][x] = true;
                    bfs(new Point(y, x), map[y][x]);
                    ++colorB;
                }
            }
        }


        System.out.println(colorA + " " + colorB);
    }

    private static void bfs(Point start, char color) {
        Queue<Point> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = point.y + dy[dir];
                int nx = point.x + dx[dir];

                if (ny < 0 || ny == n || nx < 0 || nx == n || ch[ny][nx] || map[ny][nx] != color) {
                    continue;
                }
                ch[ny][nx] = true;
                q.offer(new Point(ny, nx));
            }
        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}



















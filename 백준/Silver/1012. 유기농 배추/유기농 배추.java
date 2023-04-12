import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] ch;
    static int X, Y;

    public static void main(String[]args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[Y][X];
            ch = new boolean[Y][X];

            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                map[y][x] = 1;
            }

            System.out.println(findWorm());
        }
    }

    private static int findWorm() {
        int worm = 0;
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {

                if (!ch[y][x] && map[y][x] == 1) {
                    batch(y, x);
                    ++worm;
                }
            }
        }

        return worm;
    }

    private static void batch(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];
            if (my < 0 || my >= Y || mx < 0 || mx >= X) {
                continue;
            }
            if (!ch[my][mx] && map[my][mx] == 1) {
                ch[my][mx] = true;
                batch(my, mx);
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] moved;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx=  {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new int[y + 1][x + 1];
        moved = new boolean[y + 1][x + 1];

        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                map[i][j] = br.read() - '0';
            }
            br.readLine();
        }
        System.out.println(BFS(y, x));
    }

    private static int BFS(int y, int x) {
        Queue<Player> moveTo = new LinkedList<>();
        int my, mx, distance = 1;
        moveTo.add(new Player(1, 1));
        moved[1][1] = true;

        while (!moveTo.isEmpty()) {
            int route = moveTo.size();
            for (int r = 0;  r < route; r++) {
                Player player = moveTo.poll();
                for (int m = 0; m < 4; m++) {
                    my = player.y + dy[m];
                    mx = player.x + dx[m];
                    if (my <= 0 || my > y || mx <= 0 || mx > x || map[my][mx] == 0 || moved[my][mx]) {
                        continue;
                    }
                    if (my == y && mx == x) {
                        return ++distance;
                    }
                    moved[my][mx] = true;
                    moveTo.offer(new Player(my, mx));
                }
            }
            distance++;
        }
        return -1;
    }

    private static class Player {
        int y;
        int x;

        public Player(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

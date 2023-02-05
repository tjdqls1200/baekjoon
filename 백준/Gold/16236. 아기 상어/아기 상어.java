import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] moved;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static Pos shark;
    static int exp, level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = 0;

        map = new int[n + 1][n + 1];
        moved = new boolean[n + 1][n + 1];
        level = 2;

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Pos(i, j);
                    map[i][j] = 0;
                }
            }
        }
        int distance = 1;
        while(distance != 0) {
            distance = BFS(n);
            answer += distance;
            if (exp == level) {
                exp = 0;
                level++;
            }
            for (int i = 0; i <= n; i++) {
                Arrays.fill(moved[i], false);
            }
        }
        System.out.println(answer);

    }

    private static int BFS(int n) {
        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> canEat = new PriorityQueue<>();
        queue.offer(shark);
        moved[shark.y][shark.x] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int s = 0; s < size; s++) {
                Pos pos = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int my = pos.y + dy[i];
                    int mx = pos.x + dx[i];
                    if (canMove(n, my, mx)) {
                        // 상어가 먹을 수 있는 위치
                        if (map[my][mx] > 0 && map[my][mx] < level) {
                            canEat.offer(new Pos(my, mx));
                            continue;
                        }
                        moved[my][mx] = true;
                        queue.offer(new Pos(my, mx));
                    }
                }
            }
            if (canEat.size() > 0) {
                Pos fish = canEat.poll();
                map[fish.y][fish.x] = 0;
                exp++;
                shark = fish;
                return distance;
            }
        }
        return 0;
    }

    private static boolean canMove(int n, int my, int mx) {
        // 맵 범위 벗어나면 이동 불가
        if (my <= 0 || my > n || mx <= 0 || mx > n) {
            return false;
        }
        // 이미 이동한 곳이거나 상어의 레벨보다 높은 경우 이동 불가
        if (moved[my][mx] || map[my][mx] > level) {
            return false;
        }
        return true;
    }
    
    private static class Pos implements Comparable<Pos> {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
}

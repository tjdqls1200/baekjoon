import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    /*
     *       상범 빌딩 탈출
     *       동, 서, 남, 북, 상, 하 이동 가능
     *
     *
     * */
    private static int[] dh = new int[]{0, 0, 0, 0, -1, 1};
    private static int[] dy = new int[]{0, -1, 0, 1, 0, 0};
    private static int[] dx = new int[]{-1, 0, 1, 0, 0, 0};

    private static final String ANSWER_FORMAT = "Escaped in %d minute(s).";
    private static final String NOT_ESCAPE = "Trapped!";

    private static int H, Y, X;
    private static char[][][] building;
    private static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String buildingSize;

        while (hasSize(buildingSize = br.readLine())) {
            StringTokenizer st = new StringTokenizer(buildingSize);
            H = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            building = new char[H][Y][X];
            visit = new boolean[H][Y][X];

            Pos start = initBuilding(br);

            int result = escapeBuilding(start);

            if (result > 0) {
                builder.append(String.format(ANSWER_FORMAT, result));
            } else {
                builder.append(NOT_ESCAPE);
            }

            builder.append("\n");
        }

        System.out.println(builder);
    }

    private static Pos initBuilding(BufferedReader br) throws IOException {
        Pos start = null;

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < Y; y++) {
                String line = br.readLine();
                for (int x = 0; x < X; x++) {
                    char ch = line.charAt(x);
                    building[h][y][x] = ch;
                    if (ch == 'S') {
                        start = new Pos(h, y, x);
                    }
                }
            }
            br.readLine();
        }
        return start;
    }

    private static int escapeBuilding(Pos start) {
        Queue<Pos> q = new LinkedList<>();
        visit[start.h][start.y][start.x] = true;
        int moved = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int l = 0; l < size; l++) {
                Pos pos = q.poll();
                for (int dir = 0; dir < 6; dir++) {
                    int mh = pos.h + dh[dir];
                    int my = pos.y + dy[dir];
                    int mx = pos.x + dx[dir];

                    if (mh < 0 || mh == H || my < 0 || my == Y || mx < 0 || mx == X ||
                            visit[mh][my][mx] || building[mh][my][mx] == '#') {
                        continue;
                    }
                    if (building[mh][my][mx] == 'E') {
                        return moved;
                    }

                    visit[mh][my][mx] = true;
                    q.offer(new Pos(mh, my, mx));
                }
            }
            ++moved;
        }

        return -1;
    }

    private static boolean hasSize(String buildingSize) {
        return !buildingSize.startsWith("0");
    }

    static class Pos {
        int h;
        int y;
        int x;

        public Pos(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }
}









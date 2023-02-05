import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String p1 = st.nextToken();
        String p2 = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        String[] kind = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
        HashMap<String, Integer> move = new HashMap<>();
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        for (int i = 0; i < 8; i++) {
            move.put(kind[i], i);
        }

        Pos king = new Pos(p1.charAt(0), p1.charAt(1));
        Pos stone = new Pos(p2.charAt(0), p2.charAt(1));
        String[] next = new String[n];
        for (int i = 0; i < n; i++) {
            next[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            int j = move.get(next[i]);
            // 왕이 이동 가능할 경우
            if ((king.x + dx[j] >= 'A' && king.x + dx[j] <= 'H') &&
                (king.y + dy[j] >= '1' && king.y + dy[j] <= '8')) {
                // 왕이 이동할 위치에 돌이 있으면
                if ((king.x + dx[j] == stone.x && king.y + dy[j] == stone.y)) {
                    // 돌도 이동 가능한 경우 둘 다 이동
                    if ((stone.x + dx[j] >= 'A' && stone.x + dx[j] <= 'H') &&
                            (stone.y + dy[j] >= '1' && stone.y + dy[j] <= '8')) {
                        king.y += dy[j];
                        king.x += dx[j];
                        stone.y += dy[j];
                        stone.x += dx[j];
                    }
                } else {
                    // 왕이 이동할 위치에 돌이 없을 경우 왕만 이동
                    king.y += dy[j];
                    king.x += dx[j];
                }
            }
        }
        System.out.println(king.x + "" + king.y);
        System.out.println(stone.x + "" + stone.y);
    }

    private static class Pos {
        char x;
        char y;

        public Pos(char x, char y) {
            this.x = x;
            this.y = y;
        }
    }
}

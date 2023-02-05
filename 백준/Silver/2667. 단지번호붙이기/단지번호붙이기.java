import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[][] map;
    static boolean[][] ch;
    static int n, cnt;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        ch = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = br.read() - '0';
            }
            br.readLine();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 1 && !ch[y][x]) {
                    ch[y][x] = true;
                    cnt = 1;
                    DFS(y, x);
                    answer.add(cnt);
                }
            }
        }
        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (Integer ans : answer) {
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }


    private static void DFS(int y, int x) {
        int my, mx;
        for (int i = 0 ; i < 4; i++) {
            my = y + dy[i];
            mx = x + dx[i];
            if (my < 0 || my == n || mx < 0 || mx == n ||
                ch[my][mx] || map[my][mx] == 0) {
                continue;
            }
            ch[my][mx] = true;
            cnt++;
            DFS(my, mx);
        }
    }
}

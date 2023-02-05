import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static boolean[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int  t = Integer.parseInt(br.readLine());
        int[][] input = new int[t][];

        ch = new boolean[t][];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ch[i] = new boolean[n + 1];
            input[i] = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < t; i++) {
            cnt = 0;
            for (int j = 1; j < input[i].length; j++) {
                DFS(input[i], j, j, ch[i]);
            }
            System.out.println(cnt);
        }

    }

    private static void DFS(int[] map,int start, int from, boolean[] check) {
        int to = map[from];
        if (!check[to]) {
            check[to] = true;
            if (start == to) {
                cnt++;
                return;
            }
            DFS(map, start, to, check);
        }
    }


}

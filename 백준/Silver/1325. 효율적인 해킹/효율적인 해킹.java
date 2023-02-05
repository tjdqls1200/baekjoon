import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] computers;
    public static boolean[] ch;
    public static boolean[][] recode;
    public static int[] result;
    public static int cnt, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ch = new boolean[n + 1];
        result = new int[n + 1];
        recode = new boolean[n + 1][n + 1];
        computers = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            computers[i] = new ArrayList<>();
        }

        // A가 B를 신뢰, B를 해킹하면 A도 해킹 B -> A
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            computers[from].add(to);
        }

        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            // 초기회
            ch = new boolean[n + 1];
            cnt = 0;

            ch[i] = true;
            DFS(i);
            // 해킹 수, 해킹한 컴퓨터 체크
            result[i] = cnt;
            recode[i] = ch;
            if (max < cnt) {
                max = cnt;
                sb = new StringBuilder();
            }
            if (cnt == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }


    private static void DFS(int i) {
        ArrayList<Integer> computer = computers[i];
        if (result[i] != 0) {
            cnt += recodeCnt(i);
            return;
        }
        for (int to : computer) {
            if (!ch[to]) {
                ch[to] = true;
                cnt++;
                DFS(to);
            }
        }
    }

    private static int recodeCnt(int i) {
        int t = 0;
        for (int j = 1; j <= n; j++) {
            if (recode[i][j] && !ch[j]) {
                ch[j] = true;
                t++;
            }
        }
        return t;
    }

}

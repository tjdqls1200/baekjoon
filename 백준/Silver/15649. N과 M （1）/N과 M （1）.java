import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] ch;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new boolean[n + 1];
        int[] comb = new int[m];
        
        DFS(0, comb);
        System.out.println(sb.toString());
    }

    private static void DFS(int L, int[] comb) {
        if (L == m) {
            for (int c : comb) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                comb[L] = i;
                DFS(L + 1, comb);
                ch[i] = false;
            }
        }
    }
}

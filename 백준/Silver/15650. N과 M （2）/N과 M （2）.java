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

        DFS(0, 1);
        System.out.println(sb.toString());
    }

    private static void DFS(int L, int p) {
        if (L == m) {
            int i = 0, cnt = 0;
            while (cnt < m) {
                if (ch[++i]) {
                    sb.append(i).append(" ");
                    cnt++;
                }
            }
            sb.append("\n");
        } else {
            for (; p <= n; p++) {
                if (!ch[p]) {
                    ch[p] = true;
                    DFS(L + 1, p);
                    ch[p] = false;
                }
            }
        }
    }
}

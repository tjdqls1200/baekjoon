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
        int[] arr = new int[m];
        ch = new boolean[n + 1];

        DFS(0, 1, arr);
        System.out.println(sb.toString());
    }

    private static void DFS(int L, int min, int[] arr) {
        if (L == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = min; i <= n; i++) {
            arr[L] = i;
            DFS(L + 1, i, arr);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] ch;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ch = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        int m = Integer.parseInt(st.nextToken());

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i]) {
                continue;
            }
            dfs(i);
            ++count;
        }
        System.out.println(count);
    }

    private static void dfs(int n) {
        final List<Integer> list = lists.get(n);
        for (int to : list) {
            if (!ch[to]) {
                ch[to] = true;
                dfs(to);
            }
        }
    }
}
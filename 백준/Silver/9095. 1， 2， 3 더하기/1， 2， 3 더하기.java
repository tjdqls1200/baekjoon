import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            dfs(0, Integer.parseInt(br.readLine()));
            sb.append(answer).append("\n");
            answer = 0;
        }
        System.out.println(sb);
    }

    private static void dfs(int sum, int result) {
        if (sum > result) {
            return;
        }
        if (sum == result) {
            ++answer;
            return;
        }

        dfs(sum + 1, result);
        dfs(sum + 2, result);
        dfs(sum + 3, result);
    }
}
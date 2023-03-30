import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class Main {
    static List<Character> LCS = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        dp = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[a.length][b.length]);

        findLcs(a, b, a.length, b.length);
        for (int i = LCS.size() - 1; i >= 0; i--) {
            System.out.print(LCS.get(i));
        }
        System.out.println();
    }

    private static void findLcs(char[] a, char[] b, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (a[i - 1] == b[j - 1]) {
            LCS.add(a[i - 1]);
            findLcs(a, b, i - 1, j - 1);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                findLcs(a, b, i - 1, j);
            } else {
                findLcs(a, b, i, j - 1);
            }
        }
    }
}
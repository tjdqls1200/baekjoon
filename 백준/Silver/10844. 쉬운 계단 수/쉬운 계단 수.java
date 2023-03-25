import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        long mod = 1_000_000_000;
        long[][] dp = new long[N + 1][10]; // [a:자리수][b:끝자리수]

        // 현재 자리수 a에서 끝자리수가 b가 될 수 있는 방법은 이전 자리수 a - 1에서 끝자리수가 b - 1, b + 1인 경우만 가능
        // 0, 9는 범위 주의

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }


        for (int n = 2; n <= N; n++) {
            for (int i = 0; i <= 9; i++) {
                if (i == 0) {
                    dp[n][i] = dp[n - 1][1] % mod;
                    continue;
                }
                if (i == 9) {
                    dp[n][i] = dp[n - 1][8] % mod;
                    continue;
                }

                dp[n][i] = (dp[n - 1][i - 1] + dp[n - 1][i + 1]) % mod;
            }
        }

        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer % mod);
    }
}
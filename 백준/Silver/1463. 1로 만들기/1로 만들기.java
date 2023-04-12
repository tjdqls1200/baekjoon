import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[]args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//        X가 3으로 나누어 떨어지면, 3으로 나눈다.
//        X가 2로 나누어 떨어지면, 2로 나눈다.
//        1을 뺀다.

        int n = Integer.parseInt(br.readLine());

        dp(n, 0);

        System.out.println(answer);
    }

    private static void dp(int n, int count) {
        if (count > answer) {
            return;
        }
        if (n == 1) {
            answer = Math.min(answer, count);
            return;
        }

        if (n % 3 == 0) {
            dp(n / 3, count + 1);
        }
        if (n % 2 == 0) {
            dp(n / 2, count + 1);
        }

        dp(n - 1, count + 1);
    }
}
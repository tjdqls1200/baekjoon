import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] numbers = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (numbers[i]) {
                continue;
            }
            if (i >= M) {
                sb.append(i).append("\n");
            }
            for (int j = i * 2; j <= N; j += i) {
                numbers[j] = true;
            }
        }

        System.out.println(sb);
    }
}

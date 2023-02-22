import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // i번째 수부터 j번째 수까지 합

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final int[] sumValues = new int[N];

        st = new StringTokenizer(br.readLine());

        sumValues[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            sumValues[i] = sumValues[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 2;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (start < 0) {
                sb.append(sumValues[end]).append("\n");
                continue;
            }
            sb.append(sumValues[end] - sumValues[start]).append("\n");
        }

        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        * Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수
        * 연속 구간의 합이 M으로 나누어 떨어지는 개수를 구하면 된다.
        *
        * M의 배수면 조건 충족
        *
        * rt 늘려가면서 lt는 0 ~ rt까지
        * rt, lt 사이구간합으로 나누어지면 count 증가
        *
        * 경우의 수
        * 1) 현재 수
        * 2) 누적합
        * 3) 구간합 -> 시간 초과
        *
        * (A + B) % M = 0 이면 A % M = 0, B % M = 0
        *
        * */

        /*
        * SUDO
        *
        * sum = [N + 1]
        * for ( i = 1 이상 ~ N 이하) {
        *   sum[i] = sum[i - 1] + nextInt
        *
        * }
        *
        * for (i = 1 ~ N) {
        *   for (j = i ~ 0) {
        *      if ((sum[i] - sum[j]) % M == 0)
        *           count++
        *   }
        * }
        *
        * */

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sum = new long[N + 1];
        long[] remainNumCount = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int remainNum = (int) (sum[i] % M);
            if (remainNum == 0) {
                answer++;
            }
            remainNumCount[remainNum] += 1;
        }

        for (int i = 0; i < M; i++) {
            if (remainNumCount[i] > 1) {
                answer = answer + (remainNumCount[i] * (remainNumCount[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}

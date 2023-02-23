import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int goodNumberCount = 0;

        // N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
        // N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력
        // 수의 위치가 다르면 값이 같아도 다른 수

        // 수가 정렬 되어 있다는 조건이 없으므로 정렬을 한다.

        final int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        if (N < 3) {
            return;
        }

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int lt;
        int rt;

        for (int i = 0; i < N; i++) {
            lt = 0;
            rt = N - 1;
            while (lt < rt) {
                if (numbers[lt] + numbers[rt] < numbers[i]) {
                    ++lt;
                    continue;
                }
                if (numbers[lt] + numbers[rt] > numbers[i]) {
                    --rt;
                    continue;
                }

                if (lt == i) {
                    ++lt;
                    continue;
                }
                if (rt == i) {
                    --rt;
                    continue;
                }

                goodNumberCount++;
                break;
            }
        }

        System.out.println(goodNumberCount);
    }
}

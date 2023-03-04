import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int end = N / 2;
        int count = 1;
        int lt = 1;
        int rt = 2;
        int sum = lt + rt;

        while (lt <= end) {
            if (sum > N) {
                sum -= lt;
                ++lt;
            }
            if (sum == N && rt != N) {
                ++count;
            }
            if (sum <= N) {
                ++rt;
                sum += rt;
            }
        }

        System.out.println(count);
    }
}

import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Main::compareToAbs);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value != 0) {
                queue.add(value);
                continue;
            }

            if (queue.isEmpty()) {
                sb.append("0").append("\n");
                continue;
            }

            sb.append(queue.poll()).append("\n");
        }

        System.out.println(sb);
    }

    private static int compareToAbs(Integer n1, Integer n2) {
        int a1 = Math.abs(n1);
        int a2 = Math.abs(n2);

        if (a1 == a2) {
            if (n1 < n2) {
                return -1;
            }
            return 1;
        }

        return a1 - a2;
    }
}

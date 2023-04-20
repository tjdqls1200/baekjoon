import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                queue.offer(num);
                continue;
            }
            int outputNumber = 0;
            if (!queue.isEmpty()) {
                outputNumber = queue.poll();
            }
            sb.append(outputNumber).append("\n");
        }

        System.out.println(sb);
    }
}
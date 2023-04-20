import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                queue.offer(num);
                continue;
            }
            int v = 0;
            if (!queue.isEmpty()) {
                v = queue.poll();
            }
            sb.append(v).append("\n");
        }

        System.out.println(sb);
    }
}
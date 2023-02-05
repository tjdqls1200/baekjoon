import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int count = calculateNumberOfCases(queue);

        System.out.println(count);

    }

    private static int calculateNumberOfCases(Queue<Integer> queue) {
        if (queue.size() < 2) {
            return 0;
        }

        int count = 0;

        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            count += sum;
            queue.offer(sum);
        }

        return count;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());

        final Deque<Node> deque = new LinkedList<>();

        // 범위 : A(i - L + 1) ~ A(i)
        // i - (i - L + 1) + 1 = L
        // rnage : L

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast().value > value) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, value));

            while (!deque.isEmpty() && deque.peekFirst().index <= i - L) {
                deque.removeFirst();
            }

            sb.append(deque.peekFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

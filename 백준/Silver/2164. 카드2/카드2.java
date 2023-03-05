import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.addFirst(i);
        }

        while (deque.size() > 1) {
            deque.removeLast();
            deque.addFirst(deque.removeLast());
        }

        System.out.println(deque.peek());
    }
}

import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            sortedArr[i] = value;
        }

        Arrays.sort(sortedArr);
        
        int idx = 0;
        for (int num : sortedArr) {
            sb.append("+").append("\n");
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == arr[idx]) {
                sb.append("-").append("\n");
                stack.pop();
                ++idx;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb);
    }
}

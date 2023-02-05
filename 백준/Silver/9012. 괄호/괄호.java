import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < n ; i++) {
            System.out.println(VPS(arr[i]));
        }
    }

    private static String VPS(String line) throws IOException {
        String answer = "NO";

        Stack<Character> stack = new Stack<>();

        for (char c : line.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return answer;
                }
                if (stack.pop() == ')') {
                    return answer;
                }
            }
        }
        if (stack.isEmpty()) {
            answer = "YES";
        }
        return answer;
    }
}

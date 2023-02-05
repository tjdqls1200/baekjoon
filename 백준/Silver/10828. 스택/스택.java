import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack <Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            execute(br.readLine());
        }
        
        System.out.println(sb);
    }

    private static void execute(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String command = st.nextToken();
        if ("push".equals(command)) {
            stack.push(Integer.parseInt(st.nextToken()));
            return;
        }
        if ("pop".equals(command)) {
            if (stack.isEmpty()) {
                sb.append("-1").append("\n");
                return;
            }
            sb.append(stack.pop()).append("\n");
        }
        if ("size".equals(command)) {
            sb.append(stack.size()).append("\n");
        }
        if ("empty".equals(command)) {
            if (stack.isEmpty()) {
                sb.append("1").append("\n");
                return;
            }
            sb.append("0").append("\n");
        }
        if ("top".equals(command)) {
            if (stack.isEmpty()) {
                sb.append("-1").append("\n");
                return;
            }
            sb.append(stack.peek()).append("\n");
        }
    }
}

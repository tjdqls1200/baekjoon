import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        while (!"0".equals(n)) {
            sb.append(solution(n)).append("\n");
            n = br.readLine();
        }

        System.out.println(sb);
    }

    private static String solution(String n) {
        char[] chars = n.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start <= end) {
            if (chars[start] != chars[end]) {
                return "no";
            }
            start++;
            end--;
        }

        return "yes";
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += solution(arr[i]);
        }
        System.out.println(answer);
    }

    private static int solution(String arr) {
        Set<Character> set = new HashSet<>();

        char[] chars = arr.toCharArray();
        set.add(chars[0]);
        char temp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (temp == chars[i]) {
                continue;
            }
            if (!set.add(chars[i])) {
                return 0;
            }
            temp = chars[i];
        }
        return 1;
    }
}

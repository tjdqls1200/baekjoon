import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Character> chars = new ArrayList<>();

        for (char ch : br.readLine().toCharArray()) {
            chars.add(ch);
        }

        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);

            sb.append(chars.indexOf(ch)).append(" ");
        }

        System.out.println(sb);
    }
}
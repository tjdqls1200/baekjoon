import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 단어 정렬
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> inputs = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for (int i =0 ; i < n; i++) {
            inputs.add(br.readLine());
        }

        List<String> words = new ArrayList<>(inputs);

        words.sort((o1, o2) -> {
            if (o2.length() == o1.length()) {
                return o1.compareTo(o2);
            }

            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}

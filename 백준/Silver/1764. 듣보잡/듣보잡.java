import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        final HashSet<String> names = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            names.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (!names.add(name)) {
                answer.add(name);
            }
        }

        answer.sort(Comparator.naturalOrder());

        final StringBuilder sb = new StringBuilder();

        sb.append(answer.size()).append("\n");
        for (String s : answer) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Integer[] answer = new Integer[m];
        ch = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        DFS(0, answer);
        System.out.println(sb.toString());
    }

    private static void DFS(int L, Integer[] answer) {
        if (L == m) {
            for (Integer a : answer) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                answer[L] = arr.get(i);
                DFS(L + 1, answer);
                ch[i] = false;
            }
        }
    }
}

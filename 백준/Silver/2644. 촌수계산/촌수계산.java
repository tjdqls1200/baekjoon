import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] ch;
    static int answer = Integer.MAX_VALUE;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>();

        // 전체 사람의 수
        int n = Integer.parseInt(br.readLine());
        ch = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            relation.add(i, new ArrayList<>());
        }

        // 구해야 되는 관계
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        // x는 y의 부모
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            relation.get(parent).add(child);
            relation.get(child).add(parent);

        }

        ch[a] = true;
        DFS(relation, a, b, 0);
        if (!flag) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void DFS(ArrayList<ArrayList<Integer>> relation, int a, int b, int cnt) {
        if (a == b) {
            answer = Math.min(answer, cnt);
            flag = true;
            return;
        }

        ArrayList<Integer> relationOfA = relation.get(a);
        for (int i = 0; i < relationOfA.size(); i++) {
            int next = relationOfA.get(i);
            if (!ch[next]) {
                ch[next] = true;
                DFS(relation, next, b, cnt + 1);
                ch[next] = false;
            }
        }
    }
}

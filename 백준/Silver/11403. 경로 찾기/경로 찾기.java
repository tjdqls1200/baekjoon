import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> arr;
    public static boolean[][] ch;
    public static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>(n + 1);
        ch = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arrIn = arr.get(i);
            for (int j = 1; j <= n; j++) {
                if ("1".equals(st.nextToken())) {
                    arrIn.add(j);
                }
            }
        }
        start = 1;
        for (int i = 1; i <= n; i++) {
            DFS(i);
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ch[i][j])
                    sb.append("1 ");
                else
                    sb.append("0 ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void DFS(int i) {
        ArrayList<Integer> arrIn = arr.get(i);
        for (int j = 0; j < arrIn.size(); j++) {
            int pos = arrIn.get(j);
            if (!ch[start][pos] && i != pos) {
                ch[start][pos] = true;
                DFS(pos);
            }
        }
    }

}

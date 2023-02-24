import java.io.*;
import java.util.*;

public class Main {
    static List<ArrayList<Integer>> connectNumbers = new ArrayList<>();
    static boolean[] connectTable;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방향 없는 그래프가 주어졌을 때, 연결 요소의 개수
        // 첫째 줄에 정점의 개수 N과 간선의 개수 M
        // 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        connectTable = new boolean[N + 1];

        for (int n = 0; n <= N; n++) {
            connectNumbers.add(n, new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connectNumbers.get(a).add(b);
            connectNumbers.get(b).add(a);
        }

        int connectLine = 0;
        for (int i = 1; i <= N; i++) {
            if (connectTable[i]) {
                continue;
            }
            
            ++connectLine;
            dfs(i);
        }


        System.out.println(connectLine);
    }

    private static void dfs(int from) {
        if (connectTable[from]) {
            return;
        }

        connectTable[from] = true;

        for (Integer to : connectNumbers.get(from)) {
            dfs(to);
        }
    }
}

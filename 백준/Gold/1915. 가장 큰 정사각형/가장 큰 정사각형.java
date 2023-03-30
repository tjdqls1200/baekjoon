import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    static List<Character> LCS = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] map = new int[y][x];

        int max = 0;
        for (int i = 0; i < y; i++) {
            String line = br.readLine();
            for (int j = 0; j < x; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (i > 0 && j > 0 && map[i][j] == 1) {
                    map[i][j] = Math.min(map[i - 1][j- 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(max * max);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,B;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        solution(max, min);

    }

    private static void solution(int max, int min) {
        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int h = min; h <= max; h++) {
            int expectationTime = cut(h, time);
            if (expectationTime < time) {
                time = expectationTime;
                height = h;
            }
            if (expectationTime == time) {
                height = Math.max(height, h);
            }
        }
        System.out.println(time + " " + height);
    }

    private static int cut(int h, int t) {
        int time = 0;
        int block = B;

        for (int i = 0; i < N; i++) {
            if (time > t) {
                return Integer.MAX_VALUE;
            }
            for (int j = 0; j < M; j++) {
                if (map[i][j] == h) continue;

                if (map[i][j] > h) {
                    time += (map[i][j] - h) * 2;
                    block += (map[i][j] - h);
                }
                if (map[i][j] < h) {
                    time += (h - map[i][j]);
                    block -= (h - map[i][j]);
                }
            }
        }

        if (block < 0) {
            return Integer.MAX_VALUE;
        }

        return time;
    }
}

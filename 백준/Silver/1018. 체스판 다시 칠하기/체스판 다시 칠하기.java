import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new char[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= y - 8; i++) {
            for (int j = 0; j <= x - 8; j++) {
                answer = Math.min(answer, paint(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int paint(int y, int x) {
        char white = 'W';
        char black = 'B';
        int whiteCount = 0;
        int blackCount = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[y + i][x + j] != white) {
                    whiteCount++;
                }
                if (map[y + i][x + j] != black) {
                    blackCount++;
                }
                white = change(white);
                black = change(black);
            }
            white = change(white);
            black = change(black);
        }

        return Math.min(whiteCount, blackCount);
    }

    private static char change(char color) {
        if (color == 'W') {
            return 'B';
        }

        return 'W';
    }
}

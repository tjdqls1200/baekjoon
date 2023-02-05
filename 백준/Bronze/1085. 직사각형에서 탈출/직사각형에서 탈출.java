import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        System.out.println(solution(x, y, w, h));
    }

    private static int solution(int x, int y, int w, int h) {
        int dx = 0;
        int dy = 0 ;

        if (x >= 0 && x <= w) {
            dx = Math.min(x, w - x);
        }
        if (x < 0 || x > w) {
            dx = Math.min(Math.abs(x), Math.abs(x - w));
        }
        if (y >= 0 && y <= h) {
            dy = Math.min(y, h - y);
        }
        if (y < 0 || y > h) {
            dy = Math.min(Math.abs(y), Math.abs(y - h));
        }

        if (Math.abs(x) > w && Math.abs(y) > h) {
            return dx + dy;
        }
        return Math.min(dx, dy);
    }
}

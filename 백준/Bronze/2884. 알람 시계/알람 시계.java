import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        m -= 45;
        if (m < 0) {
            h -= 1;
            m += 60;
        }
        if (h == -1) {
            h = 23;
        }

        System.out.println(h + " " + m);
    }
}
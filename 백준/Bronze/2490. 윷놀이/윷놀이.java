import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] answer = new char[3];
        int cnt;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cnt = 0;
            while (st.hasMoreTokens()) {
                if ("1".equals(st.nextToken()))
                    cnt += 1;
            }
            if (cnt == 4)
                cnt = -1;
            answer[i] = (char)('D' - cnt);
        }
        for (char c : answer)
            System.out.println(c);
    }
}
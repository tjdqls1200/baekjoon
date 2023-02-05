import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if ("0 0 0".equals(input)) {
                break;
            }
            st = new StringTokenizer(input);


            double a = Math.pow(Integer.parseInt(st.nextToken()), 2);
            double b = Math.pow(Integer.parseInt(st.nextToken()), 2);
            double c = Math.pow(Integer.parseInt(st.nextToken()), 2);

            if (a + b == c || a + c == b || b + c == a) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}

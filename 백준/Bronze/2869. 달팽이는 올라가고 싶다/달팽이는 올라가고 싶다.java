import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //A, B, V
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int hillUp = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int dayUp = hillUp - down;
        int newHeight = height - down;
        int answer;

        if (newHeight % dayUp != 0) {
            System.out.println(newHeight / dayUp + 1);
        } else {
            System.out.println(answer = newHeight / dayUp);
        }
    }
}

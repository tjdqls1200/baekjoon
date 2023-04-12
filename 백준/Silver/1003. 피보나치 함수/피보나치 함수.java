import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[][] record = new Integer[41][2];

    public static void main(String[]args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        record[0][0] = 1;
        record[0][1] = 0;
        record[1][0] = 0;
        record[1][1] = 1;


        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            System.out.println(record[n][0] + " " + record[n][1]);
        }
    }

    /*
    * https://st-lab.tistory.com/124
    * */
    private static Integer[] fibo(int n) {

        if (record[n][0] == null || record[n][1] == null) {
            record[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            record[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }

        return record[n];
    }
}
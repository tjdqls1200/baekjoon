import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] moneyUnits = new int[n];
        for (int i = 0; i < n; i++) {
            moneyUnits[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int remainingMoney = k;

        for (int i = n - 1; i >= 0; i--) {
            if (moneyUnits[i] <= remainingMoney) {
                count += remainingMoney / moneyUnits[i];
                remainingMoney %= moneyUnits[i];
            }
        }

        System.out.println(count);
    }
}

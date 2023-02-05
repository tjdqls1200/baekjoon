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

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken()) * 10000;
            int silver = Integer.parseInt(st.nextToken()) * 100;
            int bronze = Integer.parseInt(st.nextToken());
            arr[p] = gold + silver + bronze;
        }
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (arr[k] < arr[i]) {
                rank++;
            }
        }
        System.out.println(rank);
    }
}

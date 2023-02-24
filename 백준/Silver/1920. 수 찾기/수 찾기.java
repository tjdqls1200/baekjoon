import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            int lt = 0;
            int rt = arr.length - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (arr[mid] > x) {
                    rt = mid - 1;
                    continue;
                }
                if (arr[mid] < x) {
                    lt = mid + 1;
                    continue;
                }
                sb.append(1).append("\n");
                break;
            }
            if (lt > rt) {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}

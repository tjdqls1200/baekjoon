import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] times = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] == o2[1]) {
                    return (int) ((int) o1[0] - o2[0]);
                }
                return (int) ((int) o1[1] - o2[1]);
            }
        });

       long exitTime = 0;
       int answer = 0;

        for (long[] time : times) {
            if (exitTime <= time[0]) {
                exitTime = time[1];
                ++answer;
            }
        }
        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    /*
    *   F, S, G, U, D
    *
    *   스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고
    *   스타트링크가 있는 곳의 위치는 G층이다.
    *   강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
    *
    * */

    private static final String NO_USE_ELEVATOR = "use the stairs";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int max = F + 1;
        int[] record = new int[max];
        Queue<Integer> q = new LinkedList<>();

        q.offer(S);

        record[S] = 1;
        while (!q.isEmpty()) {
            int pos = q.poll();
            int nextUp = pos + U;
            int nextDown = pos - D;

            if (pos == G) {
                System.out.println(record[pos] - 1);
                return;
            }
            if (nextUp < max && record[nextUp] == 0) {
                record[nextUp] = record[pos] + 1;
                q.offer(nextUp);
            }
            if (nextDown > 0 && record[nextDown] == 0) {
                record[nextDown] = record[pos] + 1;
                q.offer(nextDown);
            }
        }

        System.out.println(NO_USE_ELEVATOR);
    }
}



















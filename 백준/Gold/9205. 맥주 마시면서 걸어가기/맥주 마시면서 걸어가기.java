import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++) {
            int n = Integer.parseInt(br.readLine());
            // 집
            st = new StringTokenizer(br.readLine());
            Pos player = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 편의점
            ArrayList<Pos> rest = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                rest.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // 목적지
            st = new StringTokenizer(br.readLine());
            Pos festival = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (departure(player, rest, festival)) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean departure(Pos start, ArrayList<Pos> rest, Pos dest) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        int restNum = rest.size();
        boolean[] checked = new boolean[restNum];

        while (!queue.isEmpty()) {
            Pos player = queue.poll();
            if (canArrive(player, dest)) {
                return true;
            }

            for (int i = 0; i < restNum; i++) {
                Pos pos = rest.get(i);
                if (!checked[i] && canArrive(player, pos)) {
                    checked[i] = true;
                    queue.offer(new Pos(pos.x, pos.y));
                }
            }
        }
        return false;
    }

    private static boolean canArrive(Pos start, Pos dest) {
        return (Math.abs(start.x - dest.x) + Math.abs(start.y - dest.y)) <= 1000;
    }

    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

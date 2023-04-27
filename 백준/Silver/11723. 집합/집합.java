import java.util.*;
import java.io.*;

class Main {
    static boolean[] ch;
    static List<List<Integer>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if ("all".equals(command)) {
                set = new HashSet<>();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
                continue;
            }
            if ("empty".equals(command)) {
                set = new HashSet<>();
                continue;
            }

            int value = Integer.parseInt(st.nextToken());

            if ("add".equals(command)) {
                set.add(value);
            }
            else if ("remove".equals(command)) {
                set.remove(value);
            }
            else if ("check".equals(command)) {
                if (set.contains(value)) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            }
            else if ("toggle".equals(command)) {
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    set.add(value);
                }
            }
        }

        System.out.println(sb);

    }
}
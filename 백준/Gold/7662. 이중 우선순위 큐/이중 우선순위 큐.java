import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.function.BiFunction;

class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (command.startsWith("I")) {
                    treeMap.merge(value, 1, Integer::sum);
                    continue;
                }
                if (treeMap.isEmpty()) {
                    continue;
                }
                int key;
                if (value == 1) {
                    key = treeMap.lastKey();
                } else {
                    key = treeMap.firstKey();
                }
                if (treeMap.get(key) == 1) {
                    treeMap.remove(key);
                } else {
                    treeMap.merge(key, -1, Integer::sum);
                }
            }
            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
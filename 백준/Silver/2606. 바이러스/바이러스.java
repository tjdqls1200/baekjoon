import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> computers;
    public static boolean[] ch;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        computers = new ArrayList<>();
        ch = new boolean[n + 1];
        answer = 0;
        
        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }
        
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers.get(a).add(b);
            computers.get(b).add(a);
        }
        ch[1] = true;
        DFS(1);
        System.out.println(answer);
    }
    private static void DFS(int i) {
        ArrayList<Integer> computer = computers.get(i);
        for (int j = 0; j < computer.size(); j++) {
            int connect = computer.get(j);
            if (!ch[connect]) {
                ch[connect] = true;
                answer++;
                DFS(connect);
            }
        }
    }
}

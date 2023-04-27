import java.util.*;
import java.io.*;

class Main {
    static boolean[] ch;
    static List<List<Integer>> lists;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        lists = new ArrayList<>();
        ch = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).add(b);
            lists.get(b).add(a);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i]) {
                continue;
            }
            ++answer;
            dfs(i);
        }
        System.out.println(answer);
    
    }
    
    public static void dfs(int n) {
        List<Integer> list = lists.get(n);
        
        for (int num : list) {
            if (!ch[num]) {
                ch[num] = true;
                dfs(num);
            }
        }
    }
}
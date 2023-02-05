import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static char[] ant;
    public static Set<Character> leftSet = new HashSet<>();
    public static Set<Character> rightSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        ant = new char[n1 + n2];

        for (int i = 0; i < n1; i++) {
            ant[n1 - 1 - i] = arr1[i];
            leftSet.add(arr1[i]);
        }
        for (int i = 0; i < n2; i++) {
            ant[n1 + i] = arr2[i];
            rightSet.add(arr2[i]);
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            jump();
        }
        for (char c : ant) {
            System.out.print(c);
        }
    }

    private static void jump() {
        for (int i = 0; i < ant.length - 1; i++) {
            if (leftSet.contains(ant[i]) && rightSet.contains(ant[i + 1])) {
                swap(i++);
            }
        }
    }

    private static void swap(int i) {
        char temp = ant[i];
        ant[i] = ant[i + 1];
        ant[i + 1] = temp;
    }

}


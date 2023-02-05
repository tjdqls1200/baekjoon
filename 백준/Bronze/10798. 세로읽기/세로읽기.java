import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < 5; i++) {
            arr.add(new ArrayList<>());
            String s = br.readLine();
            max = Math.max(max, s.length());
            for (char c : s.toCharArray()) {
                arr.get(i).add(c);
            }
        }
        System.out.println(solution(arr, max));
    }

    private static String solution(ArrayList<ArrayList<Character>> arr, int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                ArrayList<Character> characters = arr.get(j);
                if (characters.size() > i) {
                    sb.append(characters.get(i));
                }
            }
        }
        return sb.toString();
    }
}
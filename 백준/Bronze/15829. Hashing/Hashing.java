import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final long COEFFICIENT = 31;
    static final long MOD = 1234567891L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String input = br.readLine();

        System.out.println(convertHashNumber(l, input));

    }

    private static long convertHashNumber(int l, String input) {
        Map<Character, Integer> converter = new HashMap<>();
        long sum = 0L;
        long pow = 1L;

        for (int i = 0; i < 26; i++) {
            converter.put((char) ('a' + i), i + 1);
        }

        /*
         * 1. 알파벳 변환
         * 2. 계수 곱 (31 * i, i = 0, 1 ..)
         * 3. M 값으로 나누기 (M = 1234567891)
         * */

        char[] inputCharacters = input.toCharArray();
        for (int i = 0; i < inputCharacters.length; i++) {
            int convertNumber = converter.get(inputCharacters[i]);
            sum += (convertNumber * pow) % MOD;
            pow = (pow * COEFFICIENT) % MOD;
        }

        return sum;
    }
}

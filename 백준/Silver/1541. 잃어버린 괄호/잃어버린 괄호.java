import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        // 괄호를 적절히 쳐서 식의 값을 최소로
        // 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
        // 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
        // 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

        final String[] numbers = br.readLine().split("-");

        int sum = addAll(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            sum -= addAll(numbers[i]);
        }

        System.out.println(sum);
    }

    private static int addAll(String number) {
        return Arrays.stream(number.split("\\+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}

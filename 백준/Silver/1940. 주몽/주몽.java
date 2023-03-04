import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> elements = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();
        int count = 0;
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            elements.add(value);
            numbers.add(value);
        }

        for (Integer num : numbers) {
            if (elements.remove(num) && elements.remove(M - num)) {
                ++count;
            }
        }

        System.out.println(count);
    }
}

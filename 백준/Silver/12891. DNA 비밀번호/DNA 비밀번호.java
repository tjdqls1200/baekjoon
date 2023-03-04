import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        final char[] dnaCharacters = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        DnaPassword password = new DnaPassword(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        int lt = 0;
        int rt = 0;
        int count = 0;

        while (rt < P) {
            password.add(dnaCharacters[rt++]);
        }

        while (rt < dnaCharacters.length) {
            if (password.canCreatePassword()) {
                ++count;
            }
            password.remove(dnaCharacters[lt++]);
            password.add(dnaCharacters[rt++]);
        }

        if (password.canCreatePassword()) {
            ++count;
        }

        System.out.println(count);
    }

    static class DnaPassword {
        final int[] standardCounts;
        final int[] countOfcharacter = new int[4];

        DnaPassword(int A, int C, int G, int T) {
            standardCounts = new int[]{A, C, G, T};
        }

        public void add(char ch) {
            countOfcharacter[indexOf(ch)] += 1;
        }

        public void remove(char ch) {
            countOfcharacter[indexOf(ch)] -= 1;
        }

        private int indexOf(char ch) {
            if (ch == 'A') {
                return 0;
            }
            if (ch == 'C') {
                return 1;
            }
            if (ch == 'G') {
                return 2;
            }
            if (ch == 'T') {
                return 3;
            }

            throw new IllegalArgumentException();
        }

        public boolean canCreatePassword() {
            return standardCounts[0] <= countOfcharacter[0] &&
                    standardCounts[1] <= countOfcharacter[1] &&
                    standardCounts[2] <= countOfcharacter[2] &&
                    standardCounts[3] <= countOfcharacter[3];
        }
    }
}

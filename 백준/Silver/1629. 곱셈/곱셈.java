import java.util.*;
import java.io.*;

class Main {
    static long m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        
        System.out.println(pow(n, p));
    }
    
    private static long pow(long n, long p) {
        if (p == 1) {
            return n % m;
        }
        
        long half = pow(n, p / 2);
        
        if (p % 2 == 1) {
            return ((half * half % m) * n) % m;
        }
        
        return half * half % m;
    }
}
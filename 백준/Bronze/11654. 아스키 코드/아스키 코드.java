import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //알파벳 소문자, 대문자, 숫자 0-9중 하나
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println((int) br.readLine().charAt(0));
    }
}
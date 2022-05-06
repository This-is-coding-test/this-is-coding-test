import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = input.charAt(0) -'0';
        for (int i = 1; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            result = Math.max(num * result, num + result);
        }
        System.out.println(result);
    }
}

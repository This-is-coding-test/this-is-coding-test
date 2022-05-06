import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count01 = 0;
        int count10 = 0;
        if (input.charAt(0) - '0' == 0) {
            count10++;
        } else {
            count01++;
        }
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) - '0' == 0 && input.charAt(i + 1) - '0' == 1) {
                count01++;
            }
            if (input.charAt(i) - '0' == 1 && input.charAt(i + 1) - '0' == 0) {
                count10++;
            }
        }
        System.out.println(Math.min(count01, count10));
    }
}

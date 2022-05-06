import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int result = Integer.parseInt(String.valueOf(S.charAt(0)));

        for (int i = 1; i < S.length(); i++) {
            int next = Integer.parseInt(String.valueOf(S.charAt(i)));
            result = Math.max(result + next, result * next);
        }
        System.out.println(result);

    }
}

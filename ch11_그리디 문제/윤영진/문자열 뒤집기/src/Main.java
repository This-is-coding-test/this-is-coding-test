import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count_0 = 0; // 0 -> 1
        int count_1 = 0; // 1 -> 0

        if (s.charAt(0) == '0') {
            count_0 = 1;
        }else {
            count_1 = 1;
        }

        for (int i = 1; i < s.length(); i++) {

            // 01 or 10
            if(s.charAt(i-1) != s.charAt(i)) {
                // 01
                if (s.charAt(i) == '1') {
                    count_1 ++;
                    // 10
                }else{
                    count_0 ++;
                }
            }
        }
        System.out.println(Math.min(count_0, count_1));

    }
}

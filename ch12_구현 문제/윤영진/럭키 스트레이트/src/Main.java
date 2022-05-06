import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        /**
         * input 123402
         *
         * length = 6 -> 0 ~ 2 / 3 ~ 5
         *
         * pre = 123
         * post = 402
          */
        String pre = s.substring(0, s.length() / 2);
        String post = s.substring(s.length() / 2);

        int result_pre = 0;
        int result_post = 0;
        for (int i = 0; i < pre.length(); i++) {
            result_pre += Integer.parseInt(String.valueOf(pre.charAt(i)));
            result_post += Integer.parseInt(String.valueOf(post.charAt(i)));
        }
        System.out.println(result_post == result_pre ? "LUCKY" : "READY");
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
//        System.out.println(s.substring(4,6));
        int result = Integer.MAX_VALUE;

        /**
         * aabbaccc
         *
         * 2a2ba3c
         *
         * 2중 for문
         * outer에서는 나눌크기 정함 길이가 8인 문자열인 경우 4번만 루프돌면되고, 10인 문자열인 경우 5번만 루프돌면됨
         *
         */

        for (int i = 1; i <= s.length() / 2; i++) {

            /**
             * 중복된 개수
             */
            int count = 1;
            /**
             * 처음 잘린 문자
             * aabbaccc -> fst = a, aa, aab, aabb
             */
            String fst = s.substring(0, i);
            String tmp = "";
            String ss = "";
            for (int j = i; j < s.length(); j += i) {

                if(j + i >= s.length()) {
                    tmp = s.substring(j, s.length());
                }else {
                    tmp = s.substring(j, j + i);
                }
                // 앞 문자열과 같은 경우
                if (fst.equals(tmp)) {
                    count++;
                } else {
                    if (count > 1) {
                        ss += count + fst;
                        // count = 2, fst = a -> 2a, j = 2
                    } else {
                        ss += fst;
                    }
                    /**
                     * 0~1: a, 1~2: a, 2~3: b, 3~4: b, 4~5: a, 5~6: c, 6~7:c, 7~8:c
                     * j = 1, 2, 3, 4, 5, 6, 7, 8
                     *
                     */
                    fst = tmp;
                    count = 1;
                }
            }
            if (count > 1) {
                ss += count + fst;
            } else {
                ss += fst;
            }
            System.out.println(ss);
            result = Math.min(result, ss.length());
        }
        System.out.println(result);
    }
}

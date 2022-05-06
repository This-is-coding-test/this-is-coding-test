import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())] += 1;
        }

        int result = 0;

        /**
         * input: 1 5 4 3 2 4 5 2
         * N = 8, M = 5
         *
         * arr: 1 2 3 4 5 6 7 8 9 10
         *      1 2 1 2 2 0 0 0 0 0
         *
         * N = 8 - 1 = 7 -> result = (0) + 1 * 7 -> weight = 1의 경우 나머지 weight 2 ~ 5까지의 곱
         * N = 7 - 2 = 5 -> result = (7) + 2 * 5 -> weight = 2의 경우 나머지 weight 3 ~ 5까지의 곱 -> weight = 2이므로 중복 제거
         * N = 5 - 1 = 4 -> result = (17) + 1 * 4 -> weight = 3의 경우 나머지 weight 4 ~ 5까지의 곱
         * N = 4 - 2 = 2 -> result = (21) + 2 * 2 -> weight = 4의 경우 나머지 weight 5까지의 곱 -> weight = 2이므로 중복 제거
         * N = 2 - 2 = 0 -> result = (25) + 0 * 2 -> weight = 5
         *
         * input: 1 4 3 2 4 5 2
         * N = 7, M = 5
         *
         * arr: 1 2 3 4 5 6 7 8 9 10
         *      1 2 1 2 1 0 0 0 0 0
         * N = 7 - 1 = 6 -> result = 1 * 6 = 6
         * N = 6 - 2 = 4 -> result = 6 + 2 * 4 = 14
         * N = 4 - 1 = 3 -> result = 14 + 1 * 3 = 17
         * N = 3 - 2 = 1 -> result = 17 + 2 * 1 = 19
         *
         */
        // 1부터 m까지의 각 무게에 대하여 처리
        for (int i = 1; i < M; i++) {
            N -= arr[i]; // 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
            result += arr[i] * N; // B가 선택하는 경우의 수와 곱해주기
        }

        System.out.println(result);

    }
}

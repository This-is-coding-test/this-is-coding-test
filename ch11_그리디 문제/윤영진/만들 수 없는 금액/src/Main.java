import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        // 1 2 4 -> 1 2 : 1 ~ 3
        // 1 2 4 -> 1 2 3 4 5 6 7

        // 1 2 5 -> 1 2 : 1 ~ 3 보장, 1 2 3 숫자가 이어지려면 다음 숫자가 나와야함 현재 5인 경우에 앞에서 더한 값(1 + 2)의 1 더한값(다음 값)보다 현재 값(5)이 크므로
        // 만들 수 없는 최소의 수는 4가 된다.

        int target = 1; // 만들어야 하는 수

        for (int i : arr) {
            if(target < i) break;
            target += i;
        }
        System.out.println(target);


    }
}

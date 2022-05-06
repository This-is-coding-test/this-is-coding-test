import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] nums;
    public static int[] op = new int[4];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        DFS(nums[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    private static void DFS(int num, int idx) {


        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        DFS(num + nums[idx], idx + 1);
                        break;
                    case 1:
                        DFS(num - nums[idx], idx + 1);
                        break;
                    case 2:
                        DFS(num * nums[idx], idx + 1);
                        break;
                    case 3:
                        DFS(num / nums[idx], idx + 1);
                        break;
                }
                op[i]++;

            }
        }

    }
}

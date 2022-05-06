import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<List<Integer>> map = new ArrayList<>();
    public static int[] d;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        d = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            d[i] = -1;
        }
        d[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {

            int now = queue.poll();
            for (int i = 0; i < map.get(now).size(); i++) {

                int next = map.get(now).get(i);

                if (d[next] == -1) {
                    d[next] = d[now] + 1;
                    queue.add(next);
                }

            }
        }
        boolean check = false;
        for (int i = 1; i < d.length; i++) {

            if (d[i] == K) {
                System.out.println(i);
                check = true;
            }

        }

        if (check == false) {
            System.out.println(-1);
        }

    }
}

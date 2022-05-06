import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (pq.size() > 1) {

            // 5 15 17 18 -> 20 17 18

            // 5 -> 17
            int first = pq.poll();

            // 15 -> 18
            int second = pq.poll();

            sum += first + second;

            pq.add(first + second);
        }

        System.out.println(sum);

    }
}

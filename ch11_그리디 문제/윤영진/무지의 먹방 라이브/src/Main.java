import java.io.IOException;
import java.util.*;

public class Main {

    public static class Food implements Comparable<Food> {

        int idx;
        int time;

        public Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Food other) {
            return Integer.compare(this.time, other.time);
        }


    }

    public static int solution(int[] food_times, long k) {

        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        // pq에 삽입 -> 알아서 time순으로 정렬
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }

        summary = 0; // 현재까지 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // 하나씩 빼보면서 k를 넘는지 안넘는지 check
        while (summary + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            summary += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        // summary = 15
        // pq -> 2 4 5
        // 남은 음식 idx순으로 sort
        List<Food> foods = new ArrayList<>();

        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.idx - o2.idx;
            }
        });

        return foods.get((int) ((k - summary) % length)).idx;
    }

    public static void main(String[] args) throws IOException {

        int[] arr = {3, 5, 1, 6, 5, 2};
        System.out.println(solution(arr, 20));

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static class Result {

        int idx;
        double val;

        public Result(int idx, double val) {
            this.idx = idx;
            this.val = val;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] arr = {1, 1, 1, 1, 1};

//        double[] result = new double[6];


        List<Result> results = new ArrayList<>();
        double length = arr.length;

        for (int i = 1; i < N + 1; i++) {
            int cur = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    cur++;
                }
            }
            if (length == 0) {
                results.add(new Result(i, 0.0));
            } else {
                results.add(new Result(i, cur / length));
                length -= cur;
            }

        }

        Collections.sort(results, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if (o1.val == o2.val) return o1.idx - o2.idx;
                if (o2.val > o1.val) {
                    return 1;
                }
                return -1;
            }
        });

        int[] answer = new int[N];

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).idx);
            answer[i] = results.get(i).idx;
        }
    }
}

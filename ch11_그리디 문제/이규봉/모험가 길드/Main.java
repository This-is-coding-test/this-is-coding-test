import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> adventurer = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adventurer.add(Integer.parseInt(st.nextToken()));
        }
        adventurer.sort(Collections.reverseOrder());

        printResult(0, adventurer, 1);
    }

    static void printResult(int i, List<Integer> adventurer, int result) {
        if (adventurer.get(i) >= adventurer.size() - i) {
            System.out.println(result);
        } else {
            printResult(adventurer.get(i), adventurer, result + 1);
        }
    }
}
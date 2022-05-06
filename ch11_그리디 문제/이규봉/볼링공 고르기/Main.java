import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        //볼링공의 개수: n
        //공의 최대 무게: m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //볼링공 무게 리스트에 저장
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        //리스트 정렬 후 현재 원소와 뒤에 나오는 원소들 비교
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) != list.get(i)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
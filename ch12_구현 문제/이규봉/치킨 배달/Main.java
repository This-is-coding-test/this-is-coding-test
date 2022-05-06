package boj_15686_치킨_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //도시의 크기(n x n)
        int n = Integer.parseInt(st.nextToken());
        //폐업시키지 않을 치킨집 최대 m개
        int m = Integer.parseInt(st.nextToken());

        //도시
        int[][] city = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //집 좌표, 치킨집 좌표 저장할 리스트
        List<int[]> houseList = new LinkedList<>();
        List<int[]> chickenList = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (city[i][j] == 1) {
                    //집 좌표 저장
                    houseList.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    //치킨집 좌표 저장
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < 1 << chickenList.size(); i++) {
            //치킨집 중 m개를 선택했다면
            if (countBits(i) == m) {
                //치킨 거리 계산
                int chickenDist = countChickenDist(houseList, chickenList, i);
                //최소 치킨 거리 갱신
                if (minDist > chickenDist) {
                    minDist = chickenDist;
                }
            }
        }

        System.out.println(minDist);
    }

    static int countBits(int n) {
        int cnt = 0;
        while (n > 0) {
            //비트에 1이 있으면
            if ((n & 1) == 1) {
                //맨 오른쪽이 1이면 카운트 증가
                cnt++;
            }
            //맨 오른쪽 비트 없애주기
            n = n >> 1;
        }
        return cnt;
    }

    static int countChickenDist(List<int[]> houseList, List<int[]> chickenList, int bit) {
        int sum = 0;

        for (int[] house : houseList) {
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chickenList.size(); i++) {
                //선택된 치킨집이라면
                if ((bit & 1 << i) != 0) {
                    int[] chicken = chickenList.get(i);
                    //치킨집과 집 사이의 거리 계산
                    int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    //최소 거리 갱신
                    if (minDist > dist) {
                        minDist = dist;
                    }
                }
            }
            //집과 가장 가까운 치킨집 사이의 거리를 더하기
            sum += minDist;
        }

        return sum;
    }
}
package boj_3190_뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //보드의 크기
        int n = Integer.parseInt(br.readLine());
        //사과의 개수
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];

        //사과의 위치
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1;
        }

        //뱀의 방향 변환 횟수
        int l = Integer.parseInt(br.readLine());

        //뱀의 방향 변환 정보
        Map<Integer, String> rotation = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            rotation.put(x, c);
        }

        br.close();

        //시간
        int time = 0;
        //방향
        int dir = 1;

        //북, 동, 남, 서
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int row = 1;
        int col = 1;

        //뱀에 해당하는 좌표를 큐로 관리
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});

        Label:
        while (true) {
            //방향 변환을 할 시간인지 확인
            if (rotation.containsKey(time)) {
                dir = (dir + (rotation.get(time).equals("D") ? 1 : 3)) % 4;
            }

            //뱀 이동
            row += dx[dir];
            col += dy[dir];

            //시간 증가
            time++;

            //보드를 벗어나면
            if (row > n || col > n || row < 1 || col < 1) {
                System.out.println(time);
                break;
            }

            //자기 자신과 부딪히면
            for (int[] loc : snake) {
                if (row == loc[0] && col == loc[1]) {
                    System.out.println(time);
                    break Label;
                }
            }

            //현재 좌표를 큐에 삽입
            snake.add(new int[]{row, col});
            //사과가 없으면 poll
            if (board[row][col] != 1) {
                snake.poll();
            } else {
                //사과가 있으면 poll하지 않고 0으로만 초기화
                board[row][col] = 0;
            }

        }

    }
}

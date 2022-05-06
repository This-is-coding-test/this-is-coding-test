import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N; // 보드 크기
    static int K; // 사과 개수

    static int[][] board;

    static int L; // 뱀의 방향 변환 횟수

    static Map<Integer, String> turnTable = new HashMap<>();

    static List<Point> snake = new LinkedList<>();

    static Point[] turn = new Point[]{new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            turnTable.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        snake.add(new Point(1, 1));

        int time = 0;
        int idx = 0;
        Point curPoint = new Point(1, 1);
        while (true) {

            time++;
            Point nextPoint = new Point(curPoint.x + turn[idx].x, curPoint.y+ turn[idx].y);

            if(check(nextPoint)) break;

            if(board[nextPoint.x][nextPoint.y] == 1) {
                snake.add(nextPoint);
                board[nextPoint.x][nextPoint.y] = 0;
            }else {
                snake.add(nextPoint);
                snake.remove(0);
            }

            if (turnTable.containsKey(time)) {

                String type = turnTable.get(time);

                if(type.equals("D")){
                    idx++;
                    if (idx == 4) idx = 0;
                }else {
                    idx--;
                    if (idx == -1) idx = 3;
                }
            }

            curPoint = nextPoint;
        }

        System.out.println(time);

    }

    private static boolean check(Point nextPoint) {

        if (nextPoint.x < 1 || nextPoint.y < 1 || nextPoint.x > N || nextPoint.y > N)
            return true;

        for (int i = 0; i < snake.size(); i++) {
            if(snake.get(i).x == nextPoint.x && snake.get(i).y == nextPoint.y)
                return true;
        }
        return false;

    }


}

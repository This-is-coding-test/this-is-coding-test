import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static int N;
    public static int L;
    public static int R;
    public static int[][] map;
    public static Point[] dir = {new Point(-1, 0), new Point(0, -1), new Point(1, 0), new Point(0, 1)};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean isUpdated = false;
        while (true) {
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (update(i, j, map, visited)) {
//                        for (int k = 0; k < N; k++) {
//                            for (int l = 0; l < N; l++) {
//                                System.out.print(map[k][l]+ " ");
//                            }
//                            System.out.println();
//                        }
                        isUpdated = true;
                    }
                }
            }
            if (!isUpdated) break;

            answer++;
            isUpdated = false;
        }

        System.out.println(answer);

    }

    private static boolean update(int i, int j, int[][] map, boolean[][] visited) {

        int sum = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));

        Queue<Point> openQ = new LinkedList<>();

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;
            openQ.add(now);
            sum += map[now.x][now.y];

            for (int k = 0; k < 4; k++) {
                int nx = now.x + dir[k].x;
                int ny = now.y + dir[k].y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (visited[nx][ny]) continue;

                int tmp = Math.abs(map[now.x][now.y] - map[nx][ny]);

                if (tmp <= R && tmp >= L)
                    queue.add(new Point(nx, ny));
            }
        }

        if (openQ.size() <= 1) return false;

        sum = sum / openQ.size();
        for (Point point : openQ) {
            map[point.x][point.y] = sum;
        }
        return true;
    }


}




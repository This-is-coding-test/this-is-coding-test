import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int result = 0;
    public static int[][] map;
    public static int[][] temp;
    public static int count = 0;
    public static Point[] points = {
            new Point(-1, 0), new Point(0, -1), new Point(0, 1), new Point(1, 0)
    };

    public static int N;
    public static int M;

    static void setWall(int count) {

        if (count == 3) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 2) {
                        dfs(i, j);
                    }
                }
            }
            result = Math.max(result, getScore());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    count += 1;
                    setWall(count);
                    map[i][j] = 0;
                    count -= 1;

                }
            }

        }

    }

    private static int getScore() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int i, int j) {

        for (int k = 0; k < 4; k++) {
            int nx = i + points[k].x;
            int ny = j + points[k].y;

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 1. 벽 3개 세우기
         * 2. 바이러스 퍼트리기
         * 3. 최대값 비교하기
         */
        setWall(0);
        System.out.println(result);

    }
}

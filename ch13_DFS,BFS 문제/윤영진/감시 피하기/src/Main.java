import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

    public static int N;
    public static String[][] map;
    public static String[][] temp;
    public static Boolean check = false;
    public static int count = 0;
    public static List<Point> teachers = new ArrayList<>();
    public static Point[] points = {
            new Point(-1, 0), new Point(0, -1), new Point(0, 1), new Point(1, 0)
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        temp = new String[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String tmp = st.nextToken();
                map[i][j] = tmp;
                if (tmp.equals("T"))
                    teachers.add(new Point(i, j));
            }
        }
        setWall(0);
        System.out.println(check == true ? "YES" : "NO");

    }

    private static void setWall(int count) {

        if (count == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            if (dfs())
                check = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    count += 1;
                    setWall(count);
                    map[i][j] = "X";
                    count -= 1;
                }
            }
        }


    }

    private static boolean dfs() {
        for (Point teacher : teachers) {
            for (int k = 0; k < 4; k++) {
                int x = teacher.x;
                int y = teacher.y;
                while (true) {
                    int nx = x + points[k].x;
                    int ny = y + points[k].y;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || temp[nx][ny].equals("O")){
                        break;
                    }
                    if (temp[nx][ny].equals("S")) {
                        return false;
                    }
                    x = nx;
                    y = ny;
                }
            }
        }
        return true;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Virus implements Comparable<Virus> {


        int x;
        int y;
        int type;
        int time;

        public Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return this.type - o.type;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] map = new int[200][200];
    public static int N;
    public static int K;
    public static int S;
    public static int X;
    public static int Y;
    public static List<Virus> virusList = new ArrayList<>();
    public static Point[] dir = {new Point(-1, 0), new Point(0, -1), new Point(1, 0), new Point(0, 1)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;

                if (x != 0)
                    virusList.add(new Virus(i, j, x, 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(virusList);

        Queue<Virus> queue = new LinkedList<>();

        for (int i = 0; i < virusList.size(); i++) {
            queue.offer(virusList.get(i));
        }

        while (!queue.isEmpty()) {

            Virus now = queue.poll();

            if (now.time == S) break;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dir[i].x;
                int ny = now.y + dir[i].y;

                if (nx < 0 || ny < 0 || nx >=N || ny >= N) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[now.x][now.y];
                    queue.add(new Virus(nx, ny, now.type, now.time + 1));

                }


            }

        }

        System.out.println(map[X-1][Y-1]);

    }

}

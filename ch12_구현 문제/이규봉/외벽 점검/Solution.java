class Solution {
    int n, minCnt;
    int[] weak;
    int[] dist;

    void solve(int cnt, int pos, int visited) {
        if (cnt > dist.length) {
            return;
        }
        if (cnt >= minCnt) {
            return;
        }

        for (int i = 0; i < weak.length; i++) {
            int nextPos = (pos + i) % weak.length;
            int diff = weak[nextPos] - weak[pos];

            if (nextPos < pos) {
                diff += n;
            }

            if (diff > dist[dist.length - cnt]) {
                break;
            }

            visited |= 1 << nextPos;
        }

        if (visited == (1 << weak.length) - 1) {
            minCnt = cnt;
            return;
        }

        for (int i = 0; i < weak.length; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }

            solve(cnt + 1, i, visited);
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;

        minCnt = Integer.MAX_VALUE;

        for (int i = 0; i < weak.length; i++) {
            solve(1, i, 0);
        }

        if (minCnt == Integer.MAX_VALUE) {
            return -1;
        }

        return minCnt;
    }

}
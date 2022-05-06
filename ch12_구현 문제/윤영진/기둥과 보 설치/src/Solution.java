

public class Solution {

    static boolean[][] pillar; // 기둥
    static boolean[][] bar; // 보

    private int[][] solution(int n, int[][] build_frame) {

        pillar = new boolean[n + 1][n + 1];
        bar = new boolean[n + 1][n + 1];
        int count = 0;

        for (int[] frame : build_frame) {
            int x = frame[0]; // x 좌표
            int y = frame[1]; // y 좌표
            int a = frame[2]; // 기둥(0) or 보(1)
            int b = frame[3]; // 삭제(0) or 설치(1)

            // 기둥
            if (a == 0) {
                // 설치
                if (b == 1) {
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                }
                // 삭제
                else {
                    pillar[x][y] = false;
                    if (canDelete(x, y) == false) {
                        pillar[x][y] = true;
                    } else {
                        count--;
                    }
                }
            }
            // 보
            else {
                if (b == 1) {
                    if (checkBar(x, y)) {
                        bar[x][y] = true;
                        count++;
                    }
                }
                // 삭제
                else {
                    bar[x][y] = false;
                    if (canDelete(x, y) == false) {
                        bar[x][y] = true;
                    } else {
                        count--;
                    }
                }
            }
        }

        int[][] answer = new int[count][3];

        count = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if(pillar[i][j]) {
                    answer[count][0] = i;
                    answer[count][1] = j;
                    answer[count++][2] = 0;
                }
                if(bar[i][j]) {
                    answer[count][0] = i;
                    answer[count][1] = j;
                    answer[count++][2] = 1;
                }
            }
        }

        return answer;

    }

    private boolean canDelete(int x, int y) {
        for (int i = Math.max(0, x - 1); i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {

                /**
                 * 하나를 지우고 canDelete함수를 호출했음
                 * 하나를 지우고 나서 check함수를 호출했을 때 문제가 생기면 지우지 못하는 경우임
                 */
                if (pillar[i][j] && checkPillar(i, j) == false)
                    return false;

                if (bar[i][j] && checkBar(i, j) == false)
                    return false;

            }
        }
        return true;


    }

    private boolean checkBar(int x, int y) {

        /**
         * 보 설치 조건
         * 한쪽 끝부분이 기둥 위에 있거나(= pillar[x][y - 1] || pillar[x + 1][y - 1])
         * 양쪽 끝부분이 다른 보와 동시에 연결되어 있어야 합니다. (= x > 0 && bar[x - 1][y] && bar[x + 1][y])
         */
        if (x > 0 && bar[x - 1][y] && bar[x + 1][y])
            return true;
        if (pillar[x][y - 1] || pillar[x + 1][y - 1])
            return true;

        return false;
    }

    private boolean checkPillar(int x, int y) {

        /**
         * 기둥 설치 조건
         * 바닥 위에 있거나 (= y == 0)
         * 보의 한쪽 끝부분 위에 있거나 (= bar[x][y] || bar[x - 1][y])
         * 또는 다른 기둥 위에 있어야 합니다. (= pillar[x][y - 1])
         */
        if (y == 0 || pillar[x][y - 1] || bar[x][y] || bar[x - 1][y])
            return true;
        return false;
    }

}
class Solution {
    int n;
    boolean[][] pillar;
    boolean[][] sheet;

    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 1][n + 1];
        sheet = new boolean[n + 1][n + 1];
        this.n = n;
        int count = 0;

        for (int[] frame : build_frame) {
            //가로좌표, 세로좌표, 종류(0:기둥, 1:보), 설치여부(0:삭제, 1:설치)
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            if (a == 0 && b == 1) {
                //기둥 설치
                if (isValidatePillar(x, y)) {
                    pillar[x][y] = true;
                    count++;
                }
            } else if (a == 1 && b == 1) {
                //보 설치
                if (isValidateSheet(x, y)) {
                    sheet[x][y] = true;
                    count++;
                }
            } else if (a == 0 && b == 0) {
                //기둥 삭제
                pillar[x][y] = false;
                if (!canDelete(x, y)) {
                    pillar[x][y] = true;
                } else {
                    count--;
                }
            } else if (a == 1 && b == 0) {
                //보 삭제
                sheet[x][y] = false;
                if (!canDelete(x, y)) {
                    sheet[x][y] = true;
                } else {
                    count--;
                }
            }
        }

        int[][] answer = new int[count][3];
        int i = 0;

        for (int x = 0; x <= n; ++x) {
            for (int y = 0; y <= n; ++y) {
                if (pillar[x][y]) {
                    answer[i++] = new int[]{x, y, 0};
                }
                if (sheet[x][y]) {
                    answer[i++] = new int[]{x, y, 1};
                }
            }
        }

        return answer;
    }

    boolean isValidatePillar(int x, int y) {
        //아래가 바닥 or 아래가 기둥
        if (y == 0 || (y > 0 && pillar[x][y-1])) {
            return true;
        }
        //왼쪽이 보
        if ((x > 0 && sheet[x - 1][y]) || sheet[x][y]) {
            return true;
        }
        return false;
    }

    boolean isValidateSheet(int x, int y) {
        //아래가 기둥 or 오른쪽 아래가 기둥
        if (y > 0 && (pillar[x][y - 1]) || (x < n && pillar[x + 1][y - 1])) {
            return true;
        }
        //왼쪽이 보 and 오른쪽이 보
        if ((x > 0 && sheet[x - 1][y]) && (x < n && sheet[x + 1][y])) {
            return true;
        }
        return false;
    }

    boolean canDelete(int x, int y) {
        for (int i = Math.max(0, x - 1); i <= Math.min(n, x + 1); i++) {
            for (int j = y; j <= Math.min(n, y + 1); j++) {
                if (pillar[i][j] && !isValidatePillar(i, j)) {
                    return false;
                }
                if (sheet[i][j] && !isValidateSheet(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
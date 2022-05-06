class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int paddingSize = key.length - 1;

        for (int r = 0; r < paddingSize + lock.length; r++) {
            for (int c = 0; c < paddingSize + lock.length; c++) {
                //회전하는 경우 4가지
                for (int d = 0; d < 4; d++) {
                    //양 쪽에 paddingSize만큼 추가하여 배열 초기화
                    int[][] arr = new int[lock.length + 2 * paddingSize][lock.length + 2 * paddingSize];
                    for (int i = 0; i < lock.length; i++) {
                        for (int j = 0; j < lock.length; j++) {
                            //배열 중앙에 자물쇠 복사
                            arr[paddingSize + i][paddingSize + j] = lock[i][j];
                        }
                    }

                    //arr에 key를 더하기
                    match(arr, key, d, r, c);
                    //키로 자물쇠를 열 수 있으면 성공
                    if (check(arr, paddingSize, lock.length)) {
                        return true;
                    }
                }
            }
        }

        //키로 자물쇠를 열 수 없으면 false
        return false;
    }

    //match()로 key를 더한 arr에서 자물쇠가 모두 1인지 확인하는 메서드
    private boolean check(int[][] arr, int paddingSize, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[paddingSize + i][paddingSize + j] != 1) {
                    return false;
                }
            }
        }

        //자물쇠가 모두 1이라면 성공
        return true;
    }

    //arr에 key를 더하는 메서드(element-wise)
    private void match(int[][] arr, int[][] key, int d, int r, int c) {
        int n = key.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (d == 1) {
                    //오른쪽으로 90도 회전
                    arr[r + i][c + j] += key[j][n - 1 - i];
                } else if (d == 2) {
                    //오른쪽으로 180도 회전
                    arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
                } else {
                    //오른쪽으로 270도 회전
                    arr[r + i][c + j] += key[n - 1 - j][i];
                }
            }
        }
    }
}
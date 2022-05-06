public class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int paddingSize = lock.length - 1;

        for (int i = 0; i < 4; i++) {
            key = rotate(key);
            int[][] paddedKey = pad(key, paddingSize);
            for (int j = 0; j < paddedKey.length - paddingSize; j++) {
                for (int k = 0; k < paddedKey.length - paddingSize; k++) {
                    if (check(lock, paddedKey, j, k)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean check(int[][] lock, int[][] paddedKey, int j, int k) {
        for (int l = 0; l < lock.length; l++) {
            for (int m = 0; m < lock.length; m++) {
                if (lock[l][m] + paddedKey[j + l][k + m] != 1) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     *
     * rotate
     *
     * new_key[0][0] = key[2][0];
     * new_key[0][1] = key[1][0];
     * new_key[0][2] = key[0][0];
     *
     * new_key[1][0] = key[2][1];
     * new_key[1][1] = key[1][1];
     * new_key[1][2] = key[0][1];
     *
     * new_key[2][0] = key[2][2];
     * new_key[2][1] = key[1][2];
     * new_key[2][2] = key[0][2];
     *
     * => new_key[i][j] = key[key.length - 1 - j][i]
     */

    private int[][] rotate(int[][] key) {
        int[][] rotatedKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotatedKey[i][j] = key[key.length - 1 - j][i];
            }
        }
        return rotatedKey;
    }

    private int[][] pad(int[][] key, int padSize) {
        int[][] paddedKey = new int[key.length + padSize * 2][key.length + padSize * 2];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                paddedKey[padSize + i][padSize + j] = key[i][j];
            }
        }
        return paddedKey;
    }

}

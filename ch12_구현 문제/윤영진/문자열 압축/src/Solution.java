public class Solution {

    public int solution(String s) {
        if (s.length() == 1) return 1;
        int answer = Integer.MAX_VALUE;
        /**
         * aabbaccc
         *
         * 2a2ba3c
         *
         * 2중 for문
         * outer에서는 나눌크기 정함 길이가 8인 문자열인 경우 4번만 루프돌면되고, 10인 문자열인 경우 5번만 루프돌면됨
         *
         */
        for (int i = 1; i <= s.length() / 2; i++) {
            /**
             * 중복된 개수
             */
            int cnt = 1; // 현재 target에 대해 중복 값
            /**
             * 처음 잘린 문자
             * aabbaccc -> fst = a, aa, aab, aabb
             */
            String target = s.substring(0, i);
            String result = "";

            for (int j = i; j < s.length(); j += i) {
                String tmp = "";
                if(j + i >= s.length()) {
                    tmp = s.substring(j);
                }else {
                    tmp = s.substring(j, j + i);
                }
                // 앞 문자열과 같은 경우
                if (target.equals(tmp)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        result += cnt + target;
                        // cnt = 2, fst = a -> 2a, j = 2
                    } else {
                        result += target;
                    }
                    /**
                     * 0~1: a, 1~2: a, 2~3: b, 3~4: b, 4~5: a, 5~6: c, 6~7:c, 7~8:c
                     * j = 1, 2, 3, 4, 5, 6, 7, 8
                     *
                     */
                    target = tmp;
                    cnt = 1;
                }
            }
            if (cnt != 1) {
                result += cnt + target;
            } else {
                result += target;
            }

            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}

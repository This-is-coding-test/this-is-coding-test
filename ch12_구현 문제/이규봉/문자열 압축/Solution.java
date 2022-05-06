class Solution {
    public static int solution(String s) {
        //압축 전 문자열 길이로 초기화
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            //압축된 결과를 저장할 변수
            StringBuilder result = new StringBuilder();
            //압축할 문자열
            String target = s.substring(0, i);
            //압축된 개수
            int count = 1;
            for (int j = i; j <= s.length(); j += i) {
                //압축할 문자열과 비교할 문자열
                String subStr = s.substring(j, Math.min(j + i, s.length()));
                //압축할 문자열과 같다면 압축 개수 증가
                //다르다면 압축된 개수와 해당 문자열 append(압축된 개수가 1이라면 생략)
                if (subStr.equals(target)) {
                    count++;
                } else {
                    result.append(count == 1 ? "" + target : count + target);
                    target = subStr;
                    count = 1;
                }
            }
            //남은 문자열 append
            result.append(target);
            //더 압축됐다면 갱신
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
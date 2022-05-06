import java.util.Stack;

public class Solution {
    static int pos;

    boolean isCorrect(String str) {
        int left = 0;
        int right = 0;
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
                left++;

            } else {
                right++;
                if (stack.isEmpty()) {
                    res = false;
                } else {
                    stack.pop();
                }
            }

            if (left == right) {
                pos = i + 1;
                return res;
            }
        }
        return true;
    }

    public String solution(String p) {
        if (p.isEmpty()) return p;

        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos);

        if (correct)
            return u + solution(v);

        String answer = "(" + solution(v) + ")";

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == ')')
                answer += "(";
            else {
                answer += ")";
            }
        }
        return answer;
    }
}

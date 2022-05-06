import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //알파벳 대문자를 담을 리스트
        List<Character> charList = new LinkedList<>();

        //숫자 합을 계산할 변수
        int sum = 0;

        //숫자라면 sum에 더하고 대문자라면 리스트에 담기
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                sum += input.charAt(i) - '0';
            } else {
                charList.add(input.charAt(i));
            }
        }

        //알파벳 순으로 이어서 출력
        charList.stream().sorted().forEach(System.out::print);
        //숫자 합 출력
        System.out.println(sum);
    }
}
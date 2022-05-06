package boj_18406_럭키_스트레이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //왼쪽 합
        int left = 0;
        //오른쪽 합
        int right = 0;
        //글자수 반
        int mid = input.length() / 2;

        //각 자릿수 더하기
        for (int i = 0; i < mid; i++) {
            left += input.charAt(i) - '0';
            right += input.charAt(mid + i) - '0';
        }

        //같다면 LUCKY 출력
        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
}

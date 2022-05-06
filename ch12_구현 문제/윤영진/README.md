
## 문자열 재정렬

- [x] 문자열의 길이 만큼 반복하며 아스키코드를 기준으로 문자와 숫자를 구분
- [x] 반복 후 문자 sorting
- [x] **숫자가 없는 경우에 대한 예외처리**

![image](https://user-images.githubusercontent.com/83503188/163707146-570a70a6-45e4-4f58-a8c4-844588739ed3.png)

## 치킨 배달

N = 5, M = 2, 치킨 집이 5개라고 가정

- [x] chicken과 house를 나눠서 list에 저장

- [x] Combination 문제
  - chicken 집이 5개, 입력으로 들어온 M = 2인 경우
  - 5개의 치킨 집중에 2개를 고르는 경우 5C2 = 10

- [x] combination 결과
   - List<List<>> result = { {chicken[0], chicken[1]}, {chicken[0]. chicken[2], ... { chicken[3], chicken[4] }}
   
- [x] result의 크기 만큼(전체 조합의 수==10) 반복하며 각 집 마다 후보 치킨집 중 하나를 선택



![KakaoTalk_20220417_175735879](https://user-images.githubusercontent.com/83503188/163707746-df731f62-dcd0-4101-ac21-6f8754ec3306.jpg)

import java.util.*;

class Solution {

    //Food 객체
    class Food {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return this.index;
        }

        public int getTime() {
            return this.time;
        }

        public void setTime(int time) {
            this.time = time;
        }


    }

    public int solution(int[] food_times, long k) {
        //Food 객체 리스트에 저장
        List<Food> foodList = new LinkedList<>();
        for (int i = 0; i < food_times.length; i++) {
            foodList.add(new Food(i + 1, food_times[i]));
        }

        int count = 0;

        while (true) {
            //다 먹었다면 끝내기
            if (foodList.isEmpty()) {
                break;
            }
            //리스트 순회
            for (Iterator<Food> iter = foodList.iterator(); iter.hasNext(); ) {
                Food food = iter.next();
                //시간이 k초면 다음에 먹을 음식 번호 반환
                if (count == k) {
                    return food.getIndex();
                }
                //음식 1초 동안 섭취
                food.setTime(food.getTime() - 1);
                //다 먹었다면 리스트에서 제거
                if (food.getTime() == 0) {
                    iter.remove();
                }
                count++;
            }
        }
        return -1;
    }
}
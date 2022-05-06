import java.util.*;

class Solution2 {

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

    }

    public int solution(int[] food_times, long k) {
        //Food 객체 리스트에 저장
        List<Food> foodList = new LinkedList<>();
        int len = food_times.length;
        for (int i = 0; i < len; i++) {
            foodList.add(new Food(i + 1, food_times[i]));
        }

        //섭취 소요 시간 순으로 정렬
        foodList.sort(Comparator.comparingInt(Food::getTime));

        int currentTime = 0;
        int index = 0;

        for (Food food : foodList) {
            //차이 계산
            long diff = food.getTime() - currentTime;
            if (diff != 0) {
                long usedTime = diff * len;
                if (usedTime <= k) {
                    //소요 시간이 k보다 작거나 같으면 k에서 빼주기
                    k -= usedTime;
                    currentTime = food.getTime();
                } else {
                    //소요 시간이 k보다 크면 음식 번호 순으로 정렬 후 나머지를 이용하여 구하기
                    k %= len;
                    foodList.subList(index, food_times.length).sort(Comparator.comparingInt(Food::getIndex));
                    return foodList.get(index + (int) k).getIndex();
                }
            }
            index++;
            len--;
        }
        return -1;
    }
}
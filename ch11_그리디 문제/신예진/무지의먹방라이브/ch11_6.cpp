#include <bits/stdc++.h>

using namespace std;

//내가 시도한 풀이 => 10초 초과 문제 발생함 ㅠ
// int solution(vector<int> food_times, long long k) {
//     int answer = 0;

//     for(int i=0; i<food_times.size(); i++){
//         int x;
//         cin>>x;
//         food_times.push_back(x); //food_times 배열에 각 음식을 먹는데 필요한 시간 집어넣어주기
//     }

//     for(int i=0; i<k; i++){
//         if((i+1) > food_times.size()){
//             i = (i % food_times.size()) -1;
//         }

//         if(food_times[i] != 0){
//             food_times[i] = food_times[i] - 1;
//         }
//         answer++;
//     }

//     answer = (answer % food_times.size()) + 1;

//     return answer;
// }


bool compare(pair<int, int> a, pair<int, int> b) {
    return a.second < b.second;
}

int solution(vector<int> food_times, long long k) {
    // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
    long long summary = 0;
    for (int i = 0; i < food_times.size(); i++) {
        summary += food_times[i];
    }
    if (summary <= k) return -1;
    
    // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
    priority_queue<pair<int, int> > pq;
    for (int i = 0; i < food_times.size(); i++) {
        // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
        pq.push({-food_times[i], i + 1});
    }
    
    summary = 0; // 먹기 위해 사용한 시간
    long long previous = 0; // 직전에 다 먹은 음식 시간
    long long length = food_times.size(); // 남은 음식의 개수

    // summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
    while (summary + ((-pq.top().first - previous) * length) <= k) {
        int now = -pq.top().first;
        pq.pop();
        summary += (now - previous) * length;
        length -= 1; // 다 먹은 음식 제외
        previous = now; // 이전 음식 시간 재설정
    }

    // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
    vector<pair<int, int> > result;
    while (!pq.empty()) {
        int food_time = -pq.top().first;
        int num = pq.top().second;
        pq.pop();
        result.push_back({food_time, num});
    }
    sort(result.begin(), result.end(), compare); // 음식의 번호 기준으로 정렬
    return result[(k - summary) % length].second;
}

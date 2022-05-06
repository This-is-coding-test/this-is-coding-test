#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstring>

using namespace std;

//원형 큐, 최대값 먼저 대입 등으로 시도해보다가 안돼서 답안의 도움을 얻은 문제ㅠ 나중에 꼭 또 풀어보기

int solution(int n, vector<int> weak, vector<int> dist) {
    int length = weak.size(); //취약지점 갯수
    
    for (int i = 0; i < length; i++) {
        weak.push_back(weak[i] + n); //1,3,4,9,10,""13,15,16,21,22""
    }

    // 투입할 친구 수의 최솟값을 찾기 위한 answer 초기값 설정
    int answer = dist.size() + 1;

    // 0부터 length - 1까지의 위치를 각각 시작점으로 설정
    for (int start = 0; start < length; start++) { //취약지점 갯수만큼
        // 친구를 나열하는 모든 경우 각각에 대하여 확인
        do {
            int cnt = 1; // 투입할 친구의 수
            
            //첫번째 친구가 레스토랑 시작점부터 갈수있는 거리를
            //for문으로 일일이 살펴보려는거야 "완전탐색"
            int position = weak[start] + dist[cnt - 1];  // 해당 친구가 점검할 수 있는 마지막 위치
            
            for (int index = start; index < start + length; index++) { //시작점부터 모든 취약지점 확인

                if (position < weak[index]) {  //갈 수 있는 최대 거리보다 더 살펴볼 지점이 길다면, 남았다면
                    cnt += 1; // 새로운 친구를 투입
                    if (cnt > dist.size()) { // 더 투입이 불가능하다면 탐색 종료
                        break;
                    }
                    position = weak[index] + dist[cnt - 1]; //dist[cnt-1] : 그다음 친구의 가능 거리 
                }
            }
            answer = min(answer, cnt); // 최솟값 계산
        } while(next_permutation(dist.begin(), dist.end())); //next_permutation 다음 순열로 넘어가기
    }
    if (answer > dist.size()) { //친구 전부 투입해도 취약지점 전부 점검하지 못하는 경우 -1 return
        return -1;
    }
    return answer;
}

int main(){


    return 0;
}
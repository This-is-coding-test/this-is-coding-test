#include<iostream>
#include<vector>
#include<string>

using namespace std;

//완전히 이해가 안됨 ㅠㅜㅠㅜ 꼭 더 살펴보기

int main(){

    int n;

    cin>>n;

    vector<int> arr;    

    for(int i=0; i<n; i++){
        int x;
        cin>>x;
        arr.push_back(x);
    }

    sort(arr.begin(), arr.end());
    //여기까지는 내가 그냥 작성한 코드들
    //주어진 수열을 오름차순으로 정렬하고 target 값을 1부터 차근차근 올리면서
    //살펴봐야한다는 아이디어까지는 생각해냄

    //밑에는 답안 참고
    int target = 1;
    for (int i = 0; i < n; i++) {
        // 타겟보다 큰 화폐 단위가 주어지면, 만들 수 없는 금액으로 판단
        if (target < arr[i]) 
            break; 

        // 타켓보다 작은 화폐 단위일 경우, 해당 화폐 단위를 더한 값으로 타겟 금액 갱신
        target += arr[i];
    }

    // 만들 수 없는 금액 출력
    cout << target;



    return 0;
}
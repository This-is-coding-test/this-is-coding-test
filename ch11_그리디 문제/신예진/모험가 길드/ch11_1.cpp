#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//작은 숫자먼저 묶어주기

int main(){

    int n, cnt=0, groupNum=0;

    cin>>n;

    vector<int> arr;
    //arr(n) 했을땐 입력값을 못받고 00000으로 뜨더니 그냥 arr 하니까 제대로 cin 됨
    //이유를 아직 찾지 못했습니다 ㅠㅜ

    for(int i=0; i<n; i++){
        int x;
        cin>>x;
        arr.push_back(x);
    }

    // for(int i=0; i<n; i++){
    //     cout<<arr[i];
    // }

    cout << endl;

    sort(arr.begin(), arr.end()); //먼저 오름차순 정렬해주고 그룹으로 묶어주기 위함

    // for(int i=0; i<n; i++){
    //     cout<<arr[i];
    // }

    for(int i=0; i<n; i++){
        cnt += 1; //모험가 한명을 그룹에 포함시켰는데
        if(arr[i] <= cnt){ //만약에 해당 모험가의 공포도보다 그룹 내의 모험가 수가 더 많아진다면
            groupNum += 1; //그룹 수를 1늘려주고
            cnt =0; //새로운 그룹 결성을 위해 그룹당 모험가 수 0으로 초기화
        }
        //이렇게 되면 (모험가의 공포도)==(그룹당 모험가 수)가 될 경우까지만 모험가 수가 카운트되고, 새로운 그룹 결성 가능
    }

    cout<<groupNum;

    return 0;
}
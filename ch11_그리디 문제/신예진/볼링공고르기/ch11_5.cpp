#include<iostream>
#include<vector>
#include<string>

using namespace std;

//이 문제도 내 힘으로 풀어냈다! 굳
//근데 문제 내에서 변수 m이 도대체 왜 주어졌는지 모르겠네
//안써도 문제 풀림

int main(){

    int n, m, cnt=0;

    cin>>n>>m;

    vector<int> arr;

    for(int i=0; i<n; i++){
        int x;
        cin>>x;
        arr.push_back(x);
    }

    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            if(arr[i] != arr[j]){
                cnt++;
            }
        }
    }

    cout<<cnt;

    return 0;
}
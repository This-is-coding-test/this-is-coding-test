#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

//C++의 struct와 STL의 sort 함수를 공부해가며 푼 문제
//공부 후에 혼자 풀어냈으나 백준에서 돌렸을때 시간 초과 문제가 나길래 검색함
//endl 과 \n 의 메모리 활용, 시간 소요 차이 알아두면 좋을듯 

struct studentStr
{
    string name;
    int kor, eng, math;
};

bool compare(studentStr a, studentStr b){
    if(a.kor == b.kor){
        if(a.eng == b.eng){
            if(a.math == b.math){
                return a.name<b.name;
            }
            return a.math>b.math;
        }
        return a.eng<b.eng;
    }else{
        return a.kor>b.kor; //조건 안달려있으면 기본적으로 국어 내림차순으로!
    }
}

int main(){

    int n;
    cin>>n;

    vector<studentStr> stuStr(n);

    for(int i = 0; i<n; i++){
        cin>>stuStr[i].name>>stuStr[i].kor>>stuStr[i].eng>>stuStr[i].math;
    }

    sort(stuStr.begin(), stuStr.end(), compare);

    //결과 출력
    for(int i=0; i<n; i++){
        cout<<stuStr[i].name<<'\n';  //'\n' 과 endl 간의 시간 차이가 난다. endl 하면 시간 초과 나는데 '\n'쓰면 더 빠름 
        // 찾아보니 endl의 경우 flush() 함수를 겸하기 때문에 실행마다 출력 버퍼를 지워주는 과정(flush)이 생겨 "\n" 보다 확실이 속도가 느리다고 한다!
    }

    return 0;
}
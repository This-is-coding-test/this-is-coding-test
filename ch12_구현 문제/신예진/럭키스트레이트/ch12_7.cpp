#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main(){

    //str.length() 뒤에 cd 가 들어가면서 여기서는 -2를 해줘야하는데 백준에서는 안해줘도 되는!!!!!!
    //이건 시스템 차이인건가 도대체 뭘까 ㅜ.ㅜ.ㅜ.ㅜ.ㅜ.ㅜ

    string str;
    cin >> str; // cin은 공백이 왔을 때 종료되는 걸로 인식, 한 줄로 받으려면 getline 사용

    int n = str.length();

    char num[n]; 
    strcpy(num,str.c_str()); 

    int left=0, right=0; //왼쪽 절반 부분, 오른쪽 절반 부분 0으로 초기화 후 배열 읽어나가면서 각각 더해주기

    for(int i=0; i<(n/2); i++){
        left += (num[i]-'0');
        right += (num[i + (n/2)]-'0');
    }

    if(left == right){
        cout<<"LUCKY";
    }else{
        cout<<"READY";
    }

    // int n = (str.length()-2)/2;
    // int left=0, right=0;

    // for(int i=0; i<n; i++){
    //     left += str[i]-48;
    //     right += str[i+n]-48;
    // }

    // if(left == right){
    //     cout<<"LUCKY";
    // }else{
    //     cout<<"READY";
    // }


    return 0;
}
#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

int main(){

    string str;
    cin >> str; // cin은 공백이 왔을 때 종료되는 걸로 인식, 한 줄로 받으려면 getline 사용

    int n = str.length();

    //구글링!!해서 알아낸 str -> char 배열 자주 헷갈려하니까 꼭 외우고 가자 ㅠㅜ
    //https://arer.tistory.com/28 [J. deo의 그알정보]
    char num[n]; 
    strcpy(num,str.c_str()); 

    // for(int i=0; i<str.length()-2; i++){ //그냥 str.length() 치면 맨 뒤에 cd 가 같이 출력 됨
    //     cout<<num[i]<<endl;
    // }

    //*****놓친점*****
    // char 변수를 아스키 코드가 아닌 숫자로 인식하게 해주기 위해
    //-'0' 을 해줘야함!!!

    int result = num[0]-'0';

    for(int i=1; i<str.length()-2; i++){
        if(result <=1 || num[i]-'0'<=1){
            result += num[i]-'0';
        }else{
            result *= num[i]-'0';
        }
    }

    cout<<result;

    return 0;
}
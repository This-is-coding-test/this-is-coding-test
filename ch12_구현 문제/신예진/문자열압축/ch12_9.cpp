#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstring>

using namespace std;

//오래걸렸지만,,,, 내힘으로 풀었다,,,,,휴 ㅠ

int solution(string str) {
    int n = str.length()-2;
    int answer = n; //압축한 문자열 중 가장 짧은 것의 길이

    for(int unit=1; unit<=n/2; unit++){ //어차피 절반 이상을 넘어가게되면 반복이 있을 수 X
        int idx=0;
        int cnt=1;
        string output="";

        for(idx=0; idx<=n-unit; idx+=unit){
            if(str.substr(idx, unit) == str.substr(idx+unit, unit)){
                cnt++;
            }else{
                if(cnt != 1){
                    output.append(to_string(cnt));
                    output.append(str.substr(idx, unit));
                    cnt = 1;
                }else if(cnt == 1){
                    output.append(str.substr(idx, unit));
                }
            }
        }

        cout<<output<<endl;

        if(output.size() <= answer){
            answer = output.length();
        }
    }

    return answer; //압축한 문자열 중 가장 짧은 것의 길이
}

int main(){

    string str;
    cin >> str; 

    cout<<solution(str);

    return 0;
}
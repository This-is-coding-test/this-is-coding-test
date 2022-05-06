#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

//혼자 힘으로 풀었다!
//다만 char형의 문자, 숫자, 아스키코드 활용 단디 알아두고 가기

int main(){

    string str;
    cin >> str; 

    int n = str.length()-2;

    char input[n]; 
    strcpy(input, str.c_str()); 
    vector<char> alphabet;
    int num=0;

    for(int i=0; i<n; i++){
        if(65 <= input[i]){
            alphabet.push_back(input[i]);
        }else if (48 <= input[i] <= 57){
            num += (input[i]-'0');
        }
    }

    sort(alphabet.begin(), alphabet.end());

    for(int i=0; i<alphabet.size(); i++){
        cout<<alphabet[i];
    }

    cout<<num;

    return 0;
}
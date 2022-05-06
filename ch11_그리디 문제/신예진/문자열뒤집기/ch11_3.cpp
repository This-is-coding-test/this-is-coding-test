#include<iostream>
#include<vector>
#include<string>

using namespace std;

//구글링 한번도 안하고 스스로 풀어냈다ㅎㅎ 뿌듯!

int main(){

    int cnt0=0, cnt1=0;
    string str;

    cin >> str;
    int n = str.length();

    char arr[n]; 
    strcpy(arr,str.c_str()); 

    for(int i=1; i<str.length()-2; i++){
        if(arr[i] != arr[i-1]){
            if(arr[i]-'0' == 0){
                cnt0++;
            }else if(arr[i]-'0' == 1){
                cnt1++;
            }
        }else{
            continue;
        }
    }

    if(cnt0 <= cnt1){
        cout<<cnt0;
    }else{
        cout<<cnt1;
    }

    return 0;
}
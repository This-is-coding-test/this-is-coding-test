#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/* 
  중간값 구하는 문제.
  중간값에서 멀어질 수록 값이 커진다는 것을 알 수 있음.
  이런 비슷한 문제들이 기본 문제로 자주 출제됨. 외워놓는 것이 좋을 듯 함.
 */

int main() {
	//다른 사람 코드 참고해 보니 시간 제한 최대한 하기 위해서 아래코드도 추가함.
	//ios_base::sync_with_stdio(false);
	//cin.tie(NULL);
	//cout.tie(NULL);

	int N;
	cin >> N;
	
	vector<int>house(N);
	for (int i = 0; i < N; i++) cin >> house[i];

	sort(house.begin(), house.end());

	cout << house[(N - 1) / 2];
}
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/* 푼 과정 및 생각 과정*/
/*  1. 학생 수가 최대로 들어오는게 큰 숫자고 한 학생 당 세개의 점수가 들어옴 > 벡터 사용 필요
    2. 각각 과목이랑 이름마다 벡터를 만들어 봄. 코드가 지저분해지고 비교하기 어려워짐. sort를 사용해서 비교하려고
	하다보니 구조체 형식으로 벡터에 느는 것이 좋을 것 같음.
	3. 벡터로 입력 받아오는 것 까지 완료. 정렬을 할 함수 생성.
	4. compare 함수로 각 학생들 비교해서 정렬

	> 이 문제는 배열을 이용해서 3차원 배열로 하기엔 학생 수의 제한의 너무 큼. 따라서 벡터를 사용하는 문제.
	정렬을 쉽게 하려면 algorithm에서 제공하는 sort 함수로 벡터를 비교하면 쉽게 비교 가능.
	비교하는 함수는 다양한 방식으로 비교 가능. 밑에 내가 한 방식 외에 다른 사람이 비교한 것도 주석으로 추가함.
*/

//구조체 형태로 학생의 점수들을 저장
struct score
{
	int kor, eng, math;
	string name;
};

bool compare(score a, score b) {
	if (a.kor == b.kor) {
		if (a.eng == b.eng) {
			if (a.math == b.math) {
				return a.name < b.name; //사전 순 증가하는 순서로 정렬
			}
			else return a.math > b.math; //수학 점수가 감소하는 순서로 정렬
		}
		else return a.eng < b.eng; //영어 점수가 증가하는 순서로 정렬
	}
	else {
		return a.kor > b.kor; //국어 점수가 감소하는 순서로 정렬
	}

	/* 이렇게 뒤에서부터 비교하는 방식도 있다. 간결해서 참고용으로 첨부
	if (a.kor == b.kor && a.eng == b.eng && a.math == b.math) return a.name < b.name;
	if (a.kor == b.kor && a.eng == b.eng) return a.math > b.math;
	if (a.kor == b.kor) return a.eng < b.eng;
	return a.kor > b.kor;
	*/
}

int main() {
	int N;
	cin >> N;

	vector<score> arr(N);
	for (int i = 0; i < N; i++) {
		cin >> arr[i].name >> arr[i].kor >> arr[i].eng >> arr[i].math;
	}
	sort(arr.begin(), arr.end(), compare); //sort(첫번째주소, 마지막주소, 정렬형태)
	//첫번째주소의 값부터 마지막 주소의 값까지를 정렬의 형태로 설정한 함수에 따라 정렬해라

	for (int j = 0; j < N; j++) {
		cout << arr[j].name << '\n';
	}
}
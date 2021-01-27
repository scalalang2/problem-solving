#include <iostream>
#define MAX 201

using namespace std;

int arr[MAX]; // 전구의 수
int n, k;

// 문제 : 전구의 색이 모두 같아지도록 하는 경우의 수 구하기
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    for(int i = 1; i < n + 1; i++) {
        cin >> arr[i];
    }

    // 1 1 2 3 3 3 2 2 1 1
    // 3 -> 2
    // 2 -> 1
    // 모두 같은 색이 되기 위해서 바뀌어야 하는 최소 수

    // 1 1 2 3 3 3 1 2 1 1
    // 조건, 인접한 색 중 하나로 변경해야 한다.
    // i 번째 전구를 k색으로 변경하는 경우
    // 0 0 1 2

    // 같은 색이었다면 dp[i-1], 다른 색이라면 dp[i-1] + 1

    return 0;
}
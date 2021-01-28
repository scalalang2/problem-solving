#include <iostream>
#include <algorithm>

using namespace std;

int N;
int arr[1001];
int dp[1001];

int main() {
    cin >> N;
    for(int i = 1; i < N + 1; i++) {
        cin >> arr[i];
    }

    // 증가하는 부분 수열 구하는 문제
    // Think.
    // {1, 100, 2, 50, 60, 3, 5, 6, 7, 8}
    // 1 2 50 60

    // 모든 경우의 수를 계산해보기
    // 1을 선택하거나 선택하지 않거나
    // 1 101
    // 0 100
    // i 번째 수를 선택했을 때, 가장 큰 부분 증가 수열은?
    // dp[i] = dp[i-1]과 dp[i] + dp[i-k]번째 수를 선택했을 때 둘 중 큰 것을 고르기
    int ans = 0;

    for(int i = 1; i < N + 1; i++) {
        dp[i] = arr[i];
        for(int k = 1; k < i; k++) {
            if(arr[k] < arr[i] && dp[i] < dp[k] + arr[i]) {
                dp[i] = dp[k] + arr[i];
            }
        }
        ans = max(ans, dp[i]);
    }

    cout << ans << endl;

    return 0;
}
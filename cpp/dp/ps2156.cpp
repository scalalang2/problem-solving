#include <iostream>
#include <algorithm>

#define MAX 10003

using namespace std;

int arr[MAX]; // 포도주 잔
int dp[MAX];
int N;
int ans;

int main () {
    cin >> N;

    for(int i = 3; i < N + 3; i++) {
        cin >> arr[i];
    }

    for(int i = 3; i < N + 3; i++) {
        dp[i] = max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
        dp[i] = max(dp[i-1], dp[i]);
        ans = max(ans, dp[i]);
    }

    cout << ans;

    return 0;
}
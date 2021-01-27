#include <iostream>
#include <algorithm>

#define MAX 1001

using namespace std;

int arr[MAX];
int dp[MAX];
int n;

int main() {
    cin >> n;
    for(int i = 1; i < n+1; i++) {
        cin >> arr[i];
    }

    // 내가 풀이한 방식
    // n개를 구매하는 방법
    // dp[i] = dp[i-k] + dp[k];
    // dp[i] = dp[k] * (n/k);
    // dp[i] = dp[i]

    // 인터넷에서 찾아본 방식
    // dp[i-p] + arr[p]
    // p개를 구매하는 경우, i-p개를 구매하는데 필요한 최대 금액

    for(int i = 1; i < n+1; i++) {
        for(int k = 1; k < i+1; k++) {
            dp[i] = max(dp[i], arr[i]);
            dp[i] = max(dp[i], dp[i-k] + dp[k]);
            if(i % k == 0) {
                dp[i] = max(dp[i], dp[k] * (i/k));
            }
        }
    }

    cout << dp[n] << endl;

    return 0;
}
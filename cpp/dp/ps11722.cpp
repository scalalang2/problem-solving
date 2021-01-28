#include <iostream>
#define MAX 1001

using namespace std;

int arr[MAX];
int dp[MAX];
int N;
int ans = 0;

// DP를 이해하려면 수학적 귀납법 처럼 생각해보라고?

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for(int i = 1; i < N + 1; i++) {
        cin >> arr[i];
    }

    for(int i = 1; i < N + 1; i++) {
        dp[i] = 1;
        for(int k = 1; k < i; k++) {
            if(arr[i] < arr[k]) {
                dp[i] = max(dp[i], dp[k] + 1);
            }
        }
        ans = max(ans, dp[i]);
    }

    cout << ans << endl;

    return 0;
}
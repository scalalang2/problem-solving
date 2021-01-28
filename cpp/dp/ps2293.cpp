#include <iostream>

using namespace std;
int n,k;
int ans;
int arr[100];
int dp[10001];

void solve() {
    // 주어진 수들로 합이 되는 경우의 수를 모두 찾으시오?
    // 10이 되는 경우의 수 = 순서는 모두 상관없이 조합만 본다면?
    // 1, 2, 5를 선택
    // 1, 2, 5
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < k+1; j++) {
            if (j >= arr[i]) {

                // 이 코드의 의미는
                // j-arr[i] 번째 동전을 세우기 위한 경우의 수를 더한다
                // dp[10] = 
                    // 동전 1을 사용해서 9를 만드는 경우의 수 
                    // 동전 1과 2를 사용해서 8을 만드는 경우의 수
                    // 동전 1과 2와 5를 사용해서 5를 만드는 경우의 수

                dp[j] += dp[j-arr[i]];
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    dp[0] = 1;
    solve();

    cout << dp[k] << endl;
    return 0;
}
#include <iostream>

using namespace std;

int n;
int arr[1001] = {0,};
int dp[1001] = {0,};
int ans;

int main() {
    cin >> n;
    for(int i = 1; i < n + 1; i++) {
        cin >> arr[i];
    }

    for(int i = 1; i < n + 1; i++) {
        for(int j = 0; j < i ; j++) {
            // dp[i] = i번째 원소에서 가장 긴 증가하는 부분 수열
            if(arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        ans = max(ans, dp[i]);
    }
    
    cout << ans << endl;
    return 0;
}


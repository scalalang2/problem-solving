#include <iostream>
#include <algorithm>
#define MAX 1001

using namespace std;

int arr[MAX];
int dp_left[MAX];
int dp_right[MAX];
int N;
int ans = 0;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;

    // 10
    // 1 5 2 1 4 3 4 5 2 1
    // 1 2 3 4 5 2 1 
    // 이분 매칭?
    // i 번째 수를 선택한 경우
    // (arr[i] < arr[k], arr[i] > arr[j]) 
    // i 에서의 가장 긴 바이토닉 수열은? 라고 접근하는게 맞나?
    // i를 선택했을 때, left의 가장 긴 증가하는 수열의 길이 +  right의 가장 긴 감소하는 수열의 길이 + 1
    for(int i = 1; i < N+1; i++) {
        cin >> arr[i];
    }

    for(int i = 1; i < N + 1; i++) {
        dp_left[i] = 1;
        for(int k = 1; k < i; k++) {
            if(arr[i] > arr[k]) {
                dp_left[i] = max(dp_left[i], dp_left[k] + 1);
            }
        }
    }

    for(int i = N; i > 0; i--) {
        dp_right[i] = 1;
        for(int k = N; k > i; k--) {
            if(arr[i] > arr[k]) {
                dp_right[i] = max(dp_right[i], dp_right[k] + 1);
            }
        }
    }

    // for(int i = 1; i < N + 1; i++) {
    //     cout << dp_left[i] << ",";
    // }
    // cout << endl;

    // for(int i = 1; i < N + 1; i++) {
    //     cout << dp_right[i] << ",";
    // }
    // cout << endl;

    for(int i = 1; i < N + 1; i++) {
        int max_left = 0;
        int max_right = 0;

        for(int k = 1; k < i; k++) {
            if(arr[i] < arr[k]) {
                max_left = max(max_left, dp_left[k]);
            }
        }
        
        for(int k = N; k > i; k--) {
            if(arr[i] > arr[k]) {
                max_right = max(max_right, dp_right[k]);
            }
        }

        ans = max(ans, max_left + max_right + 1);
    }

    cout << ans << endl;
}
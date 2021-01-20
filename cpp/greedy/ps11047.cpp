#include <iostream>

using namespace std;

int N, K;
int arr[10];
int ans = 0;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for(int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    for(int i = N-1; i >= 0; i--) {
        while(K != 0 && K / arr[i] != 0) {
            K -= arr[i];
            ans++;
        }
    }

    cout << ans << endl;

    return 0;
}
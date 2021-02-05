#include <iostream>

using namespace std;

int T;
int n;
int cost[501];
int ans = INT_MAX;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> n;
        for(int i = 1; i < n+1; i++) {
            cin >> cost[i];
        }

        // 40 30 30 50
        // 두 개의 파일 합치는 비용은 임의의 두 수의 합
        // 이 때 최종적으로 하나의 값으로 합쳐질때 까지 합산의 최소값을 찾는 문제
        for(int i = 1; i < n+1; i++) {
            solve(i);
        }
    }
}
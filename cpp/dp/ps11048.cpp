#include <iostream>

using namespace std;
int n, m;

int arr[1001][1001];
int dp[1001][1001];

int dx[3] = { 1, 0, 1 };
int dy[3] = { 0, 1, 1 };

void solve() {
    // if(x == m && y == n) {
    //     dp[n][m] = max(dp[n][m], acc);
    //     return;
    // }

    // for(int i = 0; i < 3; i++) {
    //     int nx = x + dx[i];
    //     int ny = y + dy[i];
    //     if(nx > 0 && nx <= m && ny > 0 && ny <= n) {
    //         if(dp[nx][ny])

    //         solve(nx, ny, acc + arr[ny][nx]);
    //     }
    // }

    for(int i = 1; i < n+1; i++) {
        for(int j = 1; j < m+1; j++) {
            for(int k = 0; k < 3; k++) {
                int px = j - dx[k];
                int py = i - dy[k];

                dp[i][j] = max(dp[i][j], dp[py][px] + arr[i][j]);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;

    for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < m + 1; j++) {
            cin >> arr[i][j];
        }
    }

    solve();

    cout << dp[n][m] << endl;
    return 0;
}
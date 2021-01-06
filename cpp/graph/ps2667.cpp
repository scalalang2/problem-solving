#include <iostream>
#include <cstring>
#include <algorithm>

#define MAX 25 + 2

using namespace std;

int arr[MAX][MAX] = {0,};
int visited[MAX][MAX] = {0,};
int ans = 0;
int cnt = 0;
int N = 0;
int answers[50] = {0,};

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void dfs(int i, int j) {
    visited[i][j] = 1;
    cnt++;
    for(int k = 0; k < 4; k++) {
        int nx = i + dx[k];
        int ny = j + dy[k];
        if(visited[nx][ny] == 0 && arr[nx][ny] == 1) {
            visited[nx][ny] = 1;
            dfs(nx, ny);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie();

    cin >> N;
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            scanf("%1d", &arr[i][j]);
        }
    }

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            if(visited[i][j] == 0 && arr[i][j] == 1) {
                cnt = 0;
                dfs(i, j);
                ans++;
                answers[ans] = cnt;
            }
        }
    }
    sort(answers + 1, answers + ans + 1);

    cout << ans << '\n';
    for(int i = 1; i <= ans; i++) {
        cout << answers[i] << '\n';
    }
    return 0;
}
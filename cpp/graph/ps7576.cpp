#include <iostream>
#include <queue>

#define MAX 1000 + 1

using namespace std;

struct coordinate {
    int x, y;
};

int arr[MAX][MAX] = {0,};
int m, n;
int ans = 0;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
queue<coordinate> q;

void bfs() {
    while(!q.empty()) {
        int cx = q.front().x;
        int cy = q.front().y;
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(arr[ny][nx] != -1 && arr[ny][nx] == 0) {
                    int nxt = arr[cy][cx] + 1;
                    if(nxt > ans) ans = nxt;

                    arr[ny][nx] = nxt;
                    coordinate c;
                    c.y = ny;
                    c.x = nx;
                    q.push(c);
                }
            }
        }
    }
}

bool is_failed(){
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(arr[i][j] == 0) {
                return true;
            }
        }
    }

    return false;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0 ; j < m; j++) {
            cin >> arr[i][j];
            if(arr[i][j] == 1) {
                coordinate c;
                c.x = j;
                c.y = i;
                q.push(c);
            }
        }
    }

    bfs();

    if(is_failed()) {
        cout << -1 << '\n';
    } else {
        if(ans > 0) {
            cout << ans-1 << '\n';
        } else {
            cout << ans << '\n';
        }
    }

    return 0;
}

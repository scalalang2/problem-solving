#include <iostream>
#include <queue>

#define MAX 100

using namespace std;

struct coordinate {
    int x, y;
};

// 왜 scanf("%1d")로 하면 제대로 안된거지?
// 이해할 수가 없네
string arr[MAX];
int check[MAX][MAX] = {0,};
int visited[MAX][MAX] = {0,};
int n, m;
queue<coordinate> q;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, - 1};

void bfs() {
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(arr[ny][nx] == '1' && check[ny][nx] == 0 && !visited[ny][nx]) {
                    check[ny][nx] = check[y][x] + 1;
                    visited[ny][nx] = 1;
                    
                    coordinate c;
                    c.x = nx;
                    c.y = ny;
                    q.push(c);
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    coordinate c;
    c.x = 0;
    c.y = 0;
    q.push(c);
    visited[0][0] = 1;
    bfs();

    cout << check[n-1][m-1]+1 << endl;
}
#include <iostream>
#include <stack>

using namespace std;

int visited[1002] = {0,};
int graph[1002][1002] = {0,};
int cnt = 0;

void dfs(int n, int v) {
    stack<int> s;
    s.push(v);

    while(!s.empty()) {
        int a = s.top();
        s.pop();
        if(visited[a] == 0) {
            visited[a] = 1;
            if(a == v) cnt++;
            for(int i = 1; i <= n; i++) {
                if(graph[a][i]) {
                    s.push(i);
                }
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    for(int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    for(int i = 1; i <= n; i++) {
        dfs(n, i);
    }

    cout << cnt << '\n';
}
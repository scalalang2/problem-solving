#include <iostream>
#include <stack>
#include <queue>

using namespace std;

// DFS with stack
void dfs(int graph[1002][1002], int n, int v) {
    int visited[1002] = {0,};
    stack<int> s;
    s.push(v);
    while(!s.empty()) {
        int a = s.top();
        s.pop();
        if(visited[a] == 0) {
            visited[a] = 1;
            cout << a << " ";
        
            for(int i = n; i > 0; i--) {
                if(graph[a][i] == 1) {
                    s.push(i);
                }
            }
        }
    }
    cout << '\n';
}

// BFS with stack
void bfs(int graph[1002][1002], int n, int v) {
    int visited[1002] = {0, };
    queue<int> q;
    q.push(v);
    while(!q.empty()) {
        int a = q.front();
        q.pop();
        if(visited[a] == 0) {
            visited[a] = 1;
            cout << a << " ";

            for(int i = 1; i <= n; i++) {
                if(graph[a][i] == 1) {
                    q.push(i);
                }
            }
        }
    }
}

int main() {
    int n, m, v;
    cin >> n;
    cin >> m;
    cin >> v;

    int graph[1002][1002] = {0, };

    for(int i = 0; i < m; i++) {
        int x, y;
        cin >> x;
        cin >> y;
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    dfs(graph, n, v);
    bfs(graph, n, v);
    
    return 0;
}
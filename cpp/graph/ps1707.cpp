#include <iostream>
#include <vector>
#include <queue>

#define RED 1
#define BLUE 2

using namespace std;

int visited[20002] = {0,};
vector<int> graph[20002];


void bfs(int n, int v) {
    queue<int> q;
    q.push(v);
    int color = RED;
    visited[v] = color;

    while(!q.empty()) {
        int now = q.front();
        q.pop();
        if(visited[now] == RED) {
            color = BLUE;
        } else if(visited[now] == BLUE) {
            color = RED;
        }

        int size = graph[now].size();
        for(int i = 0; i < size; i++) {
            int node = graph[now][i];
            if(!visited[node]) {
                visited[node] = color;
                q.push(node);
            }
        }
    }
}

int isBipartite(int n) {
    for(int i = 1; i <= n; i++) {
        int size = graph[i].size();
        for(int j = 0; j < size; j++) {
            int node = graph[i][j];
            if(visited[i] == visited[node]) {
                return 0;
            }
        }
    }

    return 1;
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int v, e;
        cin >> v >> e;
        for(int j = 1; j <= v; j++) {
            visited[j] = 0;
            graph[j].clear();
        }
        
        int x, y;
        for(int j = 0; j < e; j++) {
            cin >> x >> y;
            graph[x].push_back(y);
            graph[y].push_back(x);
        }

        // 이분 그래프인지 확인한다.
        for(int j = 1; j <= v; j++) {
            if(!visited[j])
                bfs(v, j);
        }

        int ans = isBipartite(v);
        if(ans == 1) {
            cout << "YES" << '\n';
        } else {
            cout << "NO" << '\n';
        }
    }
} 
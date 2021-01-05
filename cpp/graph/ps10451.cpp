#include <iostream>
#include <stack>
#include <vector>

#define MAX 1000 + 1

using namespace std;

vector<int> graph[MAX];
int visited[MAX] = {0,};
int ans = 0;

void dfs(int n, int v) {
    stack<int> s;
    s.push(v);

    while(!s.empty()) {
        int now = s.top();
        s.pop();
        if(!visited[now]) {
            if(v == now) ans++;
            visited[now] = 1;
            int size = graph[now].size();
            for(int i = 0; i < size; i++) {
                int next = graph[now][i];
                if(!visited[next])
                    s.push(next);
            }
        }
    }
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int n;
        cin >> n;
        for(int j = 1; j <= n; j++) {
            int x;
            cin >> x;
            graph[x].push_back(j);
            graph[j].push_back(x);
        }

        for(int j = 1; j <= n; j++)
            if(!visited[j])
                dfs(n, j);

        cout << ans << '\n';

        for(int j = 1; j <= n; j++) {
            graph[j].clear();
            visited[j] = 0;
        }

        ans = 0;
    }
}
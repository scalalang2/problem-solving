#include <iostream>
#include <cstring>
#include <vector>

#define MAX 100000 + 1

int team[MAX] = {0,};
int found[MAX] = {0,};
int visited[MAX] = {0,};
int t, n;
int ans = 0;

using namespace std;

void is_cycle(int start) {
    visited[start] = 1;
    int next = team[start];

    if(!visited[next]) {
        is_cycle(next);
    } else if(!found[next]) {
        for(int i = next; i != start; i = team[i])
            ans++;

        ans++;
    }

    found[start] = 1;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie();
    cin >> t;

    while(t--) {
        memset(visited, 0, sizeof(visited));
        memset(found, 0, sizeof(found));
        ans = 0;
        
        cin >> n;
        for(int i = 1; i <= n; i++) {
            int x;
            cin >> x;
            team[i] = x;
        }

        for(int i = 1; i<= n; i++)
            if(!found[i])
                is_cycle(i);

        cout << n - ans << '\n';
    }

    return 0;
}
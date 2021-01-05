#include <iostream>
#include <vector>
#include "math.h"

#define MAX 300000 + 1

int P;
int visited[MAX] = {0,};

using namespace std;

void dfs(int num) {
    visited[num]++;
    if(visited[num] == 3) {
        return;
    }
    
    int sum = 0;
    while(num) {
        sum += (int) pow(num % 10, P);
        num /= 10;
    }
    dfs(sum);
}

int main() {
    int A;
    cin >> A >> P;
    dfs(A);

    int ans = 0;

    for(int i = 0; i < MAX; i++) {
        if(visited[i] == 1){
            ans++;
        }
    }

    cout << ans << endl;

    return 0;
}
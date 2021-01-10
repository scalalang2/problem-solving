#include <iostream>
#include <algorithm>

#define MAX 100000

using namespace std;

typedef struct _node {
    int x;
    int y;
} node;

node arr[MAX];

bool compare(node a, node b) {
    if(a.y == b.y) {
        return a.x < b.x;
    } else {
        return a.y < b.y;
    }
}

int main() {
    int n;
    cin >> n;

    for(int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;

        arr[i].x = x;
        arr[i].y = y;
    }

    sort(arr, arr + n, compare);

    for(int i = 0; i < n; i++) {
         cout << arr[i].x << " " << arr[i].y << '\n';
    }
    return 0;
}
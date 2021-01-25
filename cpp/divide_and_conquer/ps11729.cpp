#include <iostream>
#include <vector>
#include <utility>

using namespace std;

struct Direction {
    int from;
    int to;
};

vector<Direction> vec;

void solve(int n, int from, int by, int to) {
    Direction d;
    d.from = from;
    d.to = to;

    if (n == 1) {
        vec.push_back(d);
    }else {
        solve(n-1, from, to, by);
        vec.push_back(d);
        solve(n-1, by, from, to);
    }
}
int main() {

    int n;
    scanf("%d", &n);
    solve(n, 1, 2, 3);
    cout << vec.size() << endl;
    for (int i = 0; i < vec.size(); i++) {
        cout << vec[i].from << " " << vec[i].to << endl;
    }

    return 0;
}
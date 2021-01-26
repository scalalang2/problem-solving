#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

struct Block {
    ll height;
    ll left;
    ll right;
    int destroyed;
};

vector<Block> vec;

bool compare(Block a, Block b) {
    if(a.height == b.height) {
        return a.left > b.left;
    } else if(a.height == b.height && a.left == b.left) {
        return a.right > b.right;
    } else {
        return a.height > b.height;
    }
}

int bomb(int X, int P) {
    int ans = 0;
    int n_of_destroy = P;

    for(int i = 0; i < vec.size(); i++) {
        if(!vec[i].destroyed && vec[i].left <= X && X <= vec[i].right && n_of_destroy > 0) {
            vec[i].destroyed = 1;
            n_of_destroy--;
            ans++;
        }
    }

    return ans;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N, Q, X, P;
    cin >> N;

    for(int i = 0; i < N; i++) {
        Block b;
        cin >> b.height;
        cin >> b.left;
        cin >> b.right;
        b.destroyed = 0;
        vec.push_back(b);
    }

    sort(vec.begin(), vec.end(), compare);

    cin >> Q;
    for(int i = 0; i < Q; i++) {
        cin >> X >> P;
        cout << bomb(X, P) << " ";
    }

    return 0;
}
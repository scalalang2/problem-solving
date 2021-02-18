#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Rank {
    int paper;
    int interview;
};

Rank ranks[100000];

int compare(Rank a, Rank b){
    return a.paper < b.paper;
}

// worst case O(n^2)
int solve(vector<Rank> vec, int n) {
    int result = 1;
    int bound = vec[0].interview;

    for(int i = 1; i < n; i++) {
        if(vec[i].interview < bound) {
            // cout << "current_bound: " << bound << "," << vec[i].interview << endl;
            bound = vec[i].interview;
            result++;
        }
    }

    return result;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t, n;
    cin >> t;
    while(t--) {
        cin >> n;
        vector<Rank> vec(n);
        for(int i = 0; i < n; i++) {
            cin >> vec[i].paper;
            cin >> vec[i].interview;
        }

        // sort ascending order by paper rank
        sort(vec.begin(), vec.end(), compare);

        // solve
        cout << solve(vec, n) << '\n';
    }

    return 0;
}
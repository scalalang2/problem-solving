#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Time {
    int begin;
    int end;
};

bool comp(Time a, Time b) {
    if(a.end == b.end) {
        return a.begin < b.begin;
    } else {
        return a.end < b.end;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;
    vector<Time> vec(N);

    for(int i = 0; i < N; i++) {
        cin >> vec[i].begin >> vec[i].end;
    }

    sort(vec.begin(), vec.end(), comp);

    int cnt = 0;
    int n = 0;

    for(int i = 0; i < vec.size(); i++) {
        if(n <= vec[i].begin) {
            n = vec[i].end;
            cnt++;
        }
    }

    cout << cnt << endl;

    return 0;
}
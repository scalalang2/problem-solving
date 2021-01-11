#include <iostream>
#include <algorithm>

#define MAX 5000000

typedef long long int ll;

using namespace std;

ll arr[MAX];

bool comp(ll a, ll b) {
    return a < b;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr, arr + n, comp);
    cout << arr[k-1] << endl;
}
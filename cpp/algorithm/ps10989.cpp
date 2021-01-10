#include <iostream>

using namespace std;

int arr[10001] = {0,};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while(n--) {
        int x;
        cin >> x;
        arr[x]++;
    }

    for(int i = 0; i < 10001; i++) {
        for(int j = 0; j < arr[i]; j++) {
            cout << i << '\n';
        }
    }

    return 0;
}
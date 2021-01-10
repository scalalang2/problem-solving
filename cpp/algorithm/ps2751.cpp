#include <iostream>
#include <algorithm>

#define MAX 1000000

using namespace std;

int arr[MAX];

int main() {
    cin.tie(0);
    int n;

    cin >> n;
    for(int i = 0; i < n; i++) {
        int num;
        cin >> num;

        arr[i] = num;
    }

    sort(arr, arr + n);

    for(int i = 0; i < n; i++) {
        cout << arr[i] << '\n';
    }

    return 0;
}
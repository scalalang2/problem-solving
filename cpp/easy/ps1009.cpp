#include <iostream>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int a, b;
    cin >> N;
    while(N--) {
        cin >> a >> b;
        int res = a % 10;
        for(int i = 0; i < b-1; i++) {
            res = (res * a) % 10;
        }
        if(res == 0) res = 10;
        cout << res << endl;
    }
}
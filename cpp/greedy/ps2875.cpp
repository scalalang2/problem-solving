#include <iostream>

using namespace std;

int N, M, K;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;

    if(N < 2) {
        cout << 0 << endl;
        return 0;
    }

    if(M == 0) {
        cout << 0 << endl;
        return 0;
    }

    while(K--) {
        if(N > M * 2) {
            N--;
        } else {
            M--;
        }
    }

    if(N > M * 2) {
         cout << M << endl;
    } else {
        cout << N/2 << endl;
    }

    return 0;
}
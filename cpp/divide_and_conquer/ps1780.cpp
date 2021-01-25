#include <iostream>
#define MAX 2187

using namespace std;

int N;
int arr[MAX][MAX] = { 0, };
int checked[MAX][MAX] = { 0, };

int only_zero = 0;
int only_one = 0;
int only_minus = 0;

void dp(int x, int y, int base) {
    int same = 0;
    int zero = 0;
    int one = 0;
    int minus = 0;

    for(int i = y; i < y+base; i++) {
        for(int j = x; j < x+base; j++) {
            if(arr[i][j] == 0) {
                zero = 1;
            } else if(arr[i][j] == 1) {
                one = 1;   
            } else {
                minus = 1;
            }
        }
    }

    if(zero == 1 && one == 0 && minus == 0) {
        only_zero++;
    } else if(zero == 0 && one == 1 && minus == 0){
        only_one++;
    } else if(zero == 0 && one == 0 && minus == 1) {
        only_minus++;
    } else {
        int new_base = (int) base/3;
        for(int i = y; i < y+base; i += new_base) {
            for(int j = x; j < x+base; j += new_base) {
                dp(j, i, new_base);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> arr[i][j];
        }
    }

    dp(0, 0, N);

    cout << only_minus << endl;
    cout << only_zero << endl;
    cout << only_one << endl;

    return 0;
}
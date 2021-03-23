#include<iostream>
using namespace std;

long long red = 1000000007;

int main(int argc, char** argv) {
        long long k, p, n;
        cin >> k >> p >> n;

        long long answer = k;
        for(int i = 0; i < n; i++) {
                answer = (answer * p) % red;
        }

        cout << answer << endl;
}
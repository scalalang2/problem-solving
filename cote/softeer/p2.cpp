#include<iostream>

using namespace std;

int work[2][1001];
int moveTime[2][1001];
int dp[2][1001];

int main(int argc, char** argv)
{
        int n;
        cin >> n;

        for(int i = 1; i < n; i++) {
                int workA, workB, moveA, moveB;
                cin >> workA >> workB >> moveA >> moveB;
                work[0][i] = workA;
                work[1][i] = workB;
                moveTime[0][i] = moveA;
                moveTime[1][i] = moveB;
        }

        cin >> work[0][n] >> work[1][n];

        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                dp[0][i] = work[0][i]; // 1
                dp[1][i] = work[1][i]; // 3
            } else {
                dp[0][i] = min(dp[0][i-1] + work[0][i], dp[1][i-1] + moveTime[1][i-1] + work[0][i]);
                dp[1][i] = min(dp[1][i-1] + work[1][i], dp[0][i-1] + moveTime[0][i-1] + work[1][i]);
            }
        }

        cout << min(dp[0][n], dp[1][n]) << endl;
        return 0;
}
#include<iostream>

using namespace std;

int work[100][101];
int moveTime[101];
int dp[100][101];

int main(int argc, char** argv)
{
        int k, n;
        cin >> k >> n;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < k; j++)
                cin >> work[j][i];

            cin >> moveTime[i];
        }

        for(int j = 0; j < k; j++)
            cin >> work[j][n];

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < k; j++) {
                if(i == 1) {
                    dp[j][i] = work[j][i];
                } else {
                    for(int l = 0; l < k; l++)
                        if(j != l)
                            dp[j][i] = min(dp[j][i-1] + work[j][i], dp[l][i-1] + moveTime[i-1] + work[j][i]);
                }
            }
        }

        int answer = dp[0][n];
        for(int i = 0; i < k; i++) {
            answer = min(answer, dp[i][n]);
        }

        cout << answer << endl;

        return 0;
}
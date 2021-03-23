#include<bits/stdc++.h>
using namespace std;

#define INF 1234567890
#define ll long long

int T;
int N;
int C[111];

int main()
{
    scanf("%d", &T);
    while(T--)
    {
        memset(C, 0, sizeof(C));
        scanf("%d", &N);
        for(int i=1; i<=N; i++)
        {
            int x;
            scanf("%d", &x);
            C[x]++;
        }
        vector<int> res;
        for(int i=0; i<=100; i++)
        {
            if (!C[i]) break;
            C[i]--;
            res.push_back(i);
        }
        for(int i=0; i<=100; i++)
        {
            while(C[i])
            {
                C[i]--;
                res.push_back(i);
            }
        }
        for(int x : res)
            printf("%d ", x);
        printf("\n");
    }
    return 0;
}
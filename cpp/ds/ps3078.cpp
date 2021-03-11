#include <iostream>
#include <queue>
#include <algorithm>
#define MAX 21
using namespace std;

queue<int> vec[MAX];

int main(){
	int n, k;
    long long cnt = 0;
	cin >> n >> k;
	for(int i=1; i<=n; i++){
		string s;
		cin >> s;
        if(!vec[s.length()].empty()) {
            int front = vec[s.length()].front();
            if(i - front <= k) {
                cnt += vec[s.length()].size();
            } else {
                while(!vec[s.length()].empty()) {
                    int fnt = vec[s.length()].front();
                    if(i - fnt > k) {
                        vec[s.length()].pop();
                    } else {
                        break;
                    }
                }
                cnt += vec[s.length()].size();
            }
        }
        vec[s.length()].push(i);
	}
	
    cout << cnt << endl;
	
	return 0;
}
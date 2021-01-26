#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
int n, ans;
string text;

int operate(int a, int b, char op) {
    int result = a;
    switch(op) {
        case '+':
            result += b;
        break;
        case '-':
            result -= b;
        break;
        case '*':
            result *= b;
        break;
    }

    return result;
}

void search(int pos, int cur) {
    if(pos > n - 1) {
        ans = max(ans, cur);
        return;
    }
    char op = (pos == 0) ? '+' : text[pos-1];

    if((pos + 2) < n) {
        int brace = operate(text[pos] - '0', text[pos+2] - '0', text[pos+1]);
        search(pos+4, operate(cur, brace, op));
    }

    search(pos+2, operate(cur, text[pos]-'0', op));
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    cin >> text;

    ans = 1 << 31; // INT MIN

    search(0, 0);
    cout << ans << endl;
}
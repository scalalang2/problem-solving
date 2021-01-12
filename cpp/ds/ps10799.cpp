#include <iostream>

using namespace std;
int stack = 0;
int ans = 0;

int main() {
    char c;
    char prev;
    while(c != '\n') {
        scanf("%c", &c);
        if(c == '(') {
            stack += 1;
        } else if(c == ')' && prev == '('){
            stack -= 1;
            ans += stack;
        } else if(c == ')' && prev == ')'){ 
            ans += 1;
            stack -= 1;
        }

        prev = c;
    }

    printf("%d", ans);
}
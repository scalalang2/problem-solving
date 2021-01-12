#include <iostream>

using namespace std;

int alphabets[26] = {0,};

int main() {
    char c;
    while(c != '\n') {
        scanf("%c", &c);
        int range = int(c) - int('a');
        if(range >= 0 && range < 26) {
            alphabets[range] += 1;
        }
    }

    for(int i = 0; i < 26; i++) {
        printf("%d ", alphabets[i]);
    }
}
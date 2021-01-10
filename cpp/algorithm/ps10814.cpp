#include <iostream>
#include <algorithm>

#define MAX 100000

using namespace std;

typedef struct _member {
    int index;
    int age;
    char name[101];
} member;

member arr[MAX];

bool compare(member i, member j) {
    if(i.age == j.age) {
        return i.index < j.index;
    } else {
        return i.age < j.age;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for(int i = 0; i < n; i++) {
        cin >> arr[i].age >> arr[i].name;
        arr[i].index = i;
    }

    stable_sort(arr, arr + n, compare);

    for(int i = 0; i < n; i++) {
        cout << arr[i].age << " " << arr[i].name << '\n';
    }

    return 0;
}
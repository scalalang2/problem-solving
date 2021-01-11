#include<iostream>
#include<map>
#include<algorithm>

typedef long long int ll;

using namespace std;

map<ll, int> m;

struct node {
    ll key;
    int value;
};

node arr[100000];

bool comp(node a, node b){
    if(a.value == b.value) {
        return a.key < b.key;
    } else {
        return a.value > b.value;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    while(n--) {
        ll num;
        cin >> num;
        m[num] += 1; 
    }

    map<ll, int>::iterator iter;

    int i = 0;
    for(iter = m.begin(); iter != m.end(); iter++) {
        arr[i].key = iter->first;
        arr[i].value = iter->second;
        i++;
    }

    sort(arr, arr + m.size(), comp);
    cout << arr[0].key << endl;
}


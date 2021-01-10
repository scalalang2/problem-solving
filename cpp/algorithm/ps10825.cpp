#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct student {
    string name;
    int kor;
    int eng;
    int math;
};

bool compare(student a, student b) {
    if(a.kor == b.kor && a.eng == b.eng && a.math == b.math) return a.name < b.name;
    else if(a.kor == b.kor && a.eng == b.eng) return a.math > b.math;
    else if(a.kor == b.kor) return a.eng < b.eng;
    else return a.kor > b.kor;
};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<student> v(n);

    for(int i = 0; i < n; i++) {
        cin >> v[i].name >> v[i].kor >> v[i].eng >> v[i].math;
    }

    sort(v.begin(), v.end(), compare);

    for(int i = 0; i < n; i++) {
        cout << v[i].name << '\n';
    }
}
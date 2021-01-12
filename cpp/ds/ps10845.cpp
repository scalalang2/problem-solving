#include <iostream>

using namespace std;

int queue[10001] = {0,};
int front = 0;
int rear = 0;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    while(n--) {
        string op;
        int x;

        cin >> op;
        if(op == "push") {
            cin >> x;
            queue[rear] = x;
            rear++;
        } else if(op == "pop") {
            if(rear == front) {
                cout << -1 << '\n';
            } else {
                cout << queue[front] << '\n';
                front++;
            }
        } else if(op == "size") {
            cout << rear-front << '\n';
        } else if(op == "empty") {
            if(rear-front == 0) {
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else if(op == "front") {
            if(front == rear) {
                cout << -1 << '\n';
            } else {
                cout << queue[front] << '\n';
            }
        } else if(op == "back") {
            if(front == rear) {
                cout << -1 << '\n';
            } else {
                cout << queue[rear-1] << '\n';
            }
        }
    }
}
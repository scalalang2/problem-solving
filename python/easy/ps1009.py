import sys
input = sys.stdin.readline

n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    result = a % 10
    for i in range(0, b-1):
        result = (result * a) % 10
    
    if result == 0:
        print(10)
    else:
        print(result)
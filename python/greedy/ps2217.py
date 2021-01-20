import math

n = int(input())
arr = []

for i in range(n):
    arr.append(int(input()))

arr = sorted(arr, reverse=True)

ans = 0
k = 0
for i in range(n):
    k += 1
    ans = max(ans, arr[i] * k)

print(ans)
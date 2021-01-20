import math

n, m = map(int, input().split())

if n == 1:
    print(1)
elif n == 2:
    print(int(min(4, (m+1)/2)))
elif m < 7:
    print(int(min(4, m)))
else:
    print(m-7+5)
# 배수 판정법을 이용한 문제
# 2의 배수는 모든 짝수는 2의 배수이다. 즉, 일의 자리가 0, 2, 4, 6, 8인 수이다.
# 3의 배수는 각 자리 숫자의 합이 3의 배수인 수이다.
# 출처: Wikipedia

import math

_has_zero = False
_sum = 0
base = 30
n = input()

for el in n:
    _sum += int(el)
    if el == '0':
        _has_zero = True

if _sum % 3 != 0 or not(_has_zero):
    print(-1)
else:
    print("".join(sorted(n, reverse=True)))
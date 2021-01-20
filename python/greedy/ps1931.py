n = int(input())
arr = []

while n != 0:
    begin, end = map(int, input().split())
    arr.append({ "begin": begin, "end": end })
    n -= 1

# 2차로 정렬할 때 사용하는 것..
# 좀 더 복잡한 방식으로 정렬하는 경우에는 쓰기 힘들듯
arr = sorted(arr, key=lambda x: (x["end"], x["begin"]))

cur = 0
cnt = 0

for i in range(len(arr)):
    if cur <= arr[i]["begin"]:
        cur = arr[i]["end"]
        cnt += 1

print(cnt)
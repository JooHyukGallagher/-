n = int(input())
data = list(map(int, input().split()))
data.sort()

result = 0
x = 0
for d in data:
    x += 1
    if x >= d:
        result += 1
        x = 0

print(result)

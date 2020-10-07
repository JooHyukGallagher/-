def solution(n, a, b):
    answer = 1

    while True:
        if (a % 2 == 1 and b - 1 == a) or (a % 2 == 0 and a - 1 == b):
            break

        a = make_new_num(a)
        b = make_new_num(b)
        answer += 1

    return answer


def make_new_num(n):
    if n % 2 == 0:
        n = int(n / 2)
    else:
        n = int((n / 2) + 1)
    return n


print(solution(8, 1, 2))
print(solution(8, 2, 3))
print(solution(8, 4, 7))

def recursive(sum, index, numbers, target):
    if index == len(numbers):
        if sum == target:
            return 1
        else:
            return 0
    return recursive(sum + numbers[index], index + 1, numbers, target) + recursive(sum + (-1) * numbers[index], index + 1, numbers, target)


def solution(numbers, target):
    answer = 0
    answer = recursive(0, 0, numbers, target)
    return answer

def solution(nums):
    answer = 0
    length = len(nums)
    pocket_num = length/2

    arr = []
    for num in nums:
        if not num in arr:
            arr.append(num)

    if len(arr) < pocket_num:
        answer = len(arr)
    else:
        answer = pocket_num

    return answer

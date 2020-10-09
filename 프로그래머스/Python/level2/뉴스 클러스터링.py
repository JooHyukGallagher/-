import math


def isAlphabet(str):
    if (ord('a') <= ord(str[0]) and ord(str[0]) <= ord('z')) and (ord('a') <= ord(str[1]) and ord(str[1]) <= ord('z')):
        return True
    else:
        return False


def solution(str1, str2):
    answer = 0

    str1 = str1.lower()
    str2 = str2.lower()

    str1Dict = {}
    for i in range(len(str1) - 1):
        element = str1[i: i + 2]
        if isAlphabet(element):
            if element in str1Dict:
                str1Dict[element] += 1
            else:
                str1Dict[element] = 1

    union = 0
    intersection = 0
    for i in range(len(str2) - 1):
        element = str2[i: i + 2]
        if isAlphabet(element):
            if element in str1Dict:
                str1Dict[element] -= 1
                if str1Dict[element] == 0:
                    str1Dict.pop(element)
                union += 1
                intersection += 1
            else:
                union += 1

    for element in str1Dict:
        union += str1Dict[element]

    if union == 0 and intersection == 0:
        answer = 1 * 65536
    elif union == 0 and intersection != 0:
        answer = 1 * 66536
    else:
        answer = math.floor((intersection / union) * 65536)

    return answer


str1 = "handshake"
str2 = "shake hands"
print(solution(str1, str2))
str1 = "aa1+aa2"
str2 = "AAAA12"
print(solution(str1, str2))
str1 = "E=M*C^2"
str2 = "e=m*c^2"
print(solution(str1, str2))

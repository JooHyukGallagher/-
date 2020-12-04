from itertools import combinations


def makeKeys(relation, keys, row_num):
    resultKey = []

    for i in range(row_num):
        keyElement = ""
        for key in keys:
            keyElement += relation[i][key]
        resultKey.append(keyElement)

    return resultKey


def isOne(tupleList):
    key_set = set()

    for tuple in tupleList:
        if tuple not in key_set:
            key_set.add(tuple)

    if len(key_set) == len(tupleList):
        return True
    else:
        return False


def solution(relation):
    answer = 0

    row_num = len(relation)
    column_num = len(relation[0])

    candidates = []
    for i in range(1, column_num+1):
        candidates.extend(combinations(range(column_num), i))

    key_dict = {}
    for keys in candidates:
        if keys not in key_dict:
            tupleList = makeKeys(relation, keys, row_num)
            if isOne(tupleList):
                answer += 1

    return answer


relation = [["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"], [
    "400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]
print(solution(relation))

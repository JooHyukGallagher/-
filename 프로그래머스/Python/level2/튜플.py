def solution(s):
    answer = []
    s_list = s[1:len(s)-1].replace('},', '}=').split('=')
    s_list = sorted([element[1:len(element)-1]
                     for element in s_list], key=lambda element: len(element))

    for element in s_list:
        for digit in element.split(','):
            if int(digit) not in answer:
                answer.append(int(digit))

    return answer


s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
s3 = "{{20,111},{111}}"
s4 = "{{123}}"
s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}"

print(solution(s1))
print(solution(s2))
print(solution(s3))
print(solution(s4))
print(solution(s5))

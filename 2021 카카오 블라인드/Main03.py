
def solution(info, query):
    answer = []

    for command in query:
        num = 0
        command = command.replace('and', ' ').split()
        for student in info:
            student = student.split()
            str1 = student[0] + student[1] + student[2] + student[3]
            str2 = ""
            if command[0] == '-':
                str2 += student[0]
            else:
                str2 += command[0]
            if command[1] == '-':
                str2 += student[1]
            else:
                str2 += command[1]
            if command[2] == '-':
                str2 += student[2]
            else:
                str2 += command[2]
            if command[3] == '-':
                str2 += student[3]
            else:
                str2 += command[3]
            if str1 == str2 and int(student[4]) >= int(command[4]):
                num += 1
        answer.append(num)

    return answer


info = [
    "java backend junior pizza 150",
    "python frontend senior chicken 210",
    "python frontend senior chicken 150",
    "cpp backend senior pizza 260",
    "java backend junior chicken 80",
    "python backend senior chicken 50"
]

query = [
    "java and backend and junior and pizza 100",
    "python and frontend and senior and chicken 200",
    "cpp and - and senior and pizza 250",
    "- and backend and senior and - 150",
    "- and - and - and chicken 100",
    "- and - and - and - 150"
]

print(solution(info, query))

def solution(record):
    answer = []

    member_dict = {}
    for message in record:
        splited_message = message.split()
        if splited_message[0] != "Leave":
            member_dict[splited_message[1]] = splited_message[2]

    for message in record:
        splited_message = message.split()
        if splited_message[0] == "Enter":
            answer.append("{}님이 들어왔습니다.".format(
                member_dict[splited_message[1]]))
        elif splited_message[0] == "Leave":
            answer.append("{}님이 나갔습니다.".format(
                member_dict[splited_message[1]]))

    return answer


record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo",
          "Leave uid1234", "Enter uid1234 Prodo",
          "Change uid4567 Ryan"]

print(solution(record))

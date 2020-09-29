def solution(n, words):
    answer = []

    wordSet = {words[0]}
    current_user = 1
    current_turn = 1
    current_word_num = 1
    prev_word = words[0]

    for i in range(1, len(words)):
        word = words[i]
        if current_user == n:
            current_user = 1
            current_turn += 1
        else:
            current_user += 1

        if word not in wordSet and prev_word[len(prev_word) - 1: len(prev_word)] == word[0]:
            current_word_num += 1
            wordSet.add(word)
            prev_word = word
        else:
            break

    if current_word_num == len(words):
        answer.append(0)
        answer.append(0)
    else:
        answer.append(current_user)
        answer.append(current_turn)
    return answer


n1 = 3
words1 = ["tank", "kick", "know", "wheel",
          "land", "dream", "mother", "robot", "tank"]
print(solution(n1, words1))

n2 = 5
words2 = ["hello", "observe", "effect", "take", "either", "recognize", "encourage",
          "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]
print(solution(n2, words2))

n3 = 2
words3 = ["hello", "one", "even", "never", "now", "world", "draw"]
print(solution(n3, words3))

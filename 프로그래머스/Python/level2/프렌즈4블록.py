def solution(m, n, board):
    answer = 0

    # block_map = [[""] * n for _ in range(m)]
    # for i in range(m):
    #     for j in range(n):
    #         block_map[i][j] = board[i][j]

    map = [[0] * n for _ in range(m)]
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j] == board[i][j+1] and board[i][j] == board[i+1, j] and board[i][j] == board[i+1][j+1]:
                map[i][j] += 1
                map[i][j+1] += 1
                map[i+1][j] += 1
                map[i+1][j+1] += 1

    for i in range(m):
        for j in range(n):
            if map[i][j] != 0:
                answer += 1

    return answer


m = 4
n = 5
board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]
print(solution(m, n, board))

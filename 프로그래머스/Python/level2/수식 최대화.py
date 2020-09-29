def solution(expression):
    answer = 0

    combination = [
        ['+', '-', '*'],
        ['+', '*', '-'],
        ['-', '+', '*'],
        ['-', '*', '+'],
        ['*', '+', '-'],
        ['*', '-', '+']
    ]

    opt = []
    for c in expression:
        if c == '+' or c == '-' or c == '*':
            opt.append(c)

    number = expression.replace(
        '-', ' ').replace('+', ' ').replace('*', ' ').split()

    new_expression = []
    for i in range(len(opt)):
        new_expression.append(number[i])
        new_expression.append(opt[i])
    new_expression.append(number[len(number)-1])

    for opt_order in combination:
        for operator in opt_order:
            idx = 1
            while len(new_expression) >= 3 and idx < len(new_expression) - 1:
                if new_expression[idx] == operator:
                    num1 = new_expression[idx - 1]
                    num2 = new_expression[idx + 1]
                    op = new_expression[idx]
                    sumTwoNum = eval(num1 + op + num2)
                    new_expression.pop(idx - 1)
                    new_expression.pop(idx)
                    new_expression.pop(idx + 1)
                    new_expression.insert(0, sumTwoNum)
                else:
                    idx += 1
        if answer < new_expression[0]:
            answer = new_expression[0]

    return answer


expression1 = "100-200*300-500+20"
expression2 = "50*6-3*2"
print(solution(expression1))
print(solution(expression2))

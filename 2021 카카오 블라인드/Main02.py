from itertools import combinations


def changeFormat(setMenus):
    menuList = []
    for menu in setMenus:
        str = ""
        for i in range(len(menu)):
            str += menu[i]
        menuList.append(str)
    return menuList


def sort_order(s):
    return (''.join(sorted(s)))


def solution(orders, course):
    answer = []

    for i in course:
        my_dict = {}
        for order in orders:
            order = sort_order(order)
            setMenus = list(combinations(order, i))
            setMenus = changeFormat(setMenus)
            for setMenu in setMenus:
                if setMenu in my_dict:
                    my_dict[setMenu] += 1
                else:
                    my_dict[setMenu] = 1
        max_num = 0
        for menu in my_dict:
            if my_dict[menu] > max_num:
                max_num = my_dict[menu]
        for menu in my_dict:
            if my_dict[menu] == max_num and my_dict[menu] >= 2:
                answer.append(menu)

    answer.sort()
    return answer


orders1 = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course1 = [2, 3, 4]
orders2 = ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]
course2 = [2, 3, 5]
orders3 = ["XYZ", "XWY", "WXA"]
course3 = [2, 3, 4]
print(solution(orders1, course1))
print(solution(orders2, course2))
print(solution(orders3, course3))

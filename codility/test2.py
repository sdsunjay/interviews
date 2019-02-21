def checkList(L):
    L.sort()
    if(L[0] == 1):
        newL = list(range(min(L), max(L)+1))
        if(L == newL):
            # print(str(L))
            return True
    return False

def solution(A):
    if not A:
        return 0
    counter = 0
    L = []
    flag = False
    for value in A:
        L.append(value)
        if(value == 1):
            flag = True
        if flag:
            if(checkList(L)):
                counter = counter + 1

    return counter
print(str(solution([2, 1, 3, 5, 4])))
print(str(solution([2, 3, 4, 1, 5])))
print(str(solution([1, 3, 4, 2, 5])))

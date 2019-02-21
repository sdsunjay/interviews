import collections
def solution(ranks):
    y = dict(collections.Counter(ranks))
    counts = 0
    for key in y.keys():
        if(key+1 in y):
            counts += y[key]
    print(str(counts))
    return counts
    # write your code in Python 3.6
solution([3, 4, 3, 0, 2, 2, 3, 0, 0])
solution([4, 2, 0])
solution([4, 2, 0, 4, 4, 4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2])
solution([3, 4, 3, 0, 2, 2, 3, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1])
solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1])
N = 10000000
count_list = range(1,N+1)
solution(count_list)
new_list = []
num = 0
while(num < len(count_list)):

    # checking condition
    if num % 2 == 0:
        new_list.append(count_list[num])

    # increment num
    num += 1
solution(new_list)

import time
# Write a function:

# def solution(A)

# that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

# For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
# create an array of equal size
   # each time we need a number in A, remove that element from the array
   # the first number left will be the number we want
   #
   # [1, 2, 3, 4, 5, 6]
   # [null, 2, 3, 4, 5, 6]
   # [null, 2, null, 4, 5, 6]
   # [null, 2, null, 4, 5, null]
def solution(A):
    start = time.time()
    # write your code in Python 3.6
    size_of_our_list = len(A)
    if size_of_our_list == 0:
        return 1
    # remove negatives before anything
    num_list = [item for item in A if item >= 0]
    size_of_our_list = len(num_list)
    if size_of_our_list == 0:
        return 1
    our_list = list(range(size_of_our_list + 2))
    our_list.remove(0)
    for integer in A:
        if integer in our_list: our_list.remove(integer)
    print(min(our_list))
    print(round(time.time() - start, 7))
    return min(our_list)

def main():
    A = [1, 3, 6, 4, 1, 2]
    solution(A)
    A = [1, 2, 3]
    solution(A)
    A = [-1, -2, -3]
    solution(A)
    A = list(range(1000))
    solution(A)
    A = list(range(0, -10000000, -1))
    solution(A)
    A = list(range(1, 0))
    solution(A)

if __name__ == '__main__':
    # use test_main to create tables and genres
    # test_main()
    main()

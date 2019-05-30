
def solution(numbers):
   if not numbers:
    return 0
   max = numbers[0]
   for num in numbers:
       if num > max:
           max = num
   return max

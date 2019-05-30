def solution(max):
     a = 0
     b = 1
     if max < 0:
         print("Incorrect input")
     elif max == 0:
         return a
     elif max == 1:
         return b
     else:
         sum = 0
         while a+b < max:
             c = a + b
             a = b
             b = c
             if b % 2 == 0:
                sum += b
         return sum


import re
def readFile(filename):
    with open(filename) as f:
        content = f.readlines()
        # you may also want to remove whitespace characters like `\n` at the end of each line
    for line in content:
        solution(line)

def solution(S):
   if not S:
       return 0
   one = S.split('.')
   two = one.split('?')
   three = two.split('!')
   sentences = three
   # sentences = [s.strip() for s in re.split('[\.\?!]' , text) if s]
   maxLength = 0
   # print(sentences)
   for sentence in sentences:
       words = sentence.split()
       if(len(words) > maxLength):
           maxLength = len(words)
   # print("Max Length is: " + str(maxLength))
   return maxLength

solution('We test coders. Give us a try?')
solution('Forget  CVs..Save time . x xi')
solution('Forget!       C Vs? .. Save...time! .? x! wxi?')
solution('I checked to make. Sure that he... was still alive.')
solution(' ')
solution(None)
solution('?!??!?!?!?!?!?!??!?!?!?!?...............')
solution('                                   !                        ?                      .')
solution('1!!!! helllo how !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!?????????????????????????????????')
solution('c...................................................................')

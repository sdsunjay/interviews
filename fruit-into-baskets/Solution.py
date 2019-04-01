# https://leetcode.com/problems/fruit-into-baskets/
class Solution:
    def totalFruit(self, tree):
      start_position = 0
      length = len(tree)
      d = {}
      new_value_count = 0
      max_count = 0
      for i in range(length):
        print(str(i)+'. '+ str(tree[i]))
        value = 0
        if tree[i] in d:
          value = d.get(tree[i])
        else:
          new_value_count = new_value_count + 1
          if new_value_count == 2:
            print('Start position: ' + str(i))
            start_position = i
          if new_value_count == 3:
            new_value_count = 1
            print('start from here: ' + str(start_position))
            i = start_position
            count = Solution.get_count_of_fruit(d)
            d = {}
            if(count > max_count):
              max_count = count

        value = value + 1
        d[tree[i]] = value

      count = Solution.get_count_of_fruit(d)
      if(count > max_count):
        max_count = count
      print('Max fruit: ' + str(max_count))
      return max_count

    def get_count_of_fruit(d):
      count = 0
      for key in d:
        count += d[key]
      print('Count of d: ' + str(count))
      return count


def main():
    Solution.totalFruit(Solution, [0,0,0,0,1,1,1,1,1,2,2,2,2,2,2,2,2,2,])


if __name__ == '__main__':
    main()

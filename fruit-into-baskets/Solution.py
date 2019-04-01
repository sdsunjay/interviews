# https://leetcode.com/problems/fruit-into-baskets/
class Solution:
    def totalFruit(self, tree):
      i = 0
      start_position = 0
      length = len(tree)
      d = {}
      new_value_count = 0
      max_count = 0
      while i < length:
        # print(str(i)+'. '+ str(tree[i]))
        value = 0
        if tree[i] in d:
          value = d.get(tree[i])
        else:
          new_value_count = new_value_count + 1
          if new_value_count == 2:
            # print('Start position: ' + str(i))
            start_position = i
          if new_value_count == 3:
            new_value_count = 1
            # print('Start from here: ' + str(start_position))
            i = start_position
            count = Solution.get_count_of_fruit(d)
            d = {}
            if(count > max_count):
              max_count = count

        value = value + 1
        d[tree[i]] = value
        i+=1

      count = Solution.get_count_of_fruit(d)
      if(count > max_count):
        max_count = count
      print('Output: ' + str(max_count))
      return max_count

    def get_count_of_fruit(d):
      count = 0
      for key in d:
        count += d[key]
      # print('Count of d: ' + str(count))
      return count


def main():
    list_of_trees = [3,3,3,1,2,1,1,2,3,3,4,1,1,1]
    print("Input: " + str(list_of_trees))
    Solution.totalFruit(Solution, list_of_trees)
    list_of_trees = [3,3,3,1,2,1,1,2,3,3,4]
    print("Input: " + str(list_of_trees))
    Solution.totalFruit(Solution, list_of_trees)
    list_of_trees = [1,1,1,2,2,2,2,3,3,3,3,3,1,1,1]
    print("Input: " + str(list_of_trees))
    Solution.totalFruit(Solution, list_of_trees)


if __name__ == '__main__':
    main()

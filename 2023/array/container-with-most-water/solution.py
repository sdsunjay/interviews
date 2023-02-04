# https://leetcode.com/problems/container-with-most-water/
class Solution:
    def getArea(self, num1, num2, index1, index2):
        base = index2 - index1
        return abs(base) * min(num1, num2)

    def maxArea(self, height: list[int]) -> int:
        if len(height) == 2:
            return self.getArea(height[0], height[1], 0, 1)
        max_area = 1
        size = len(height)
        left = 0
        right = size - 1
        while left < right:
            area = self.getArea(height[left], height[right], left, right)
            if area > max_area:
                max_area = area
            if height[left] < height[right]:
                left += 1
            else:
                right -=1
        return max_area

heights = [[1,8,6,2,5,4,8,3,7], [1,1], [5,6,2,5,4,8,3,7], [6,3,2,5,7,8,3,6],[6,6]]
sol = Solution()
for height in heights:
    print(f"Max Area {sol.maxArea(height)} for {height}")


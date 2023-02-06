# https://leetcode.com/problems/trapping-rain-water/
class Solution:
    def get_start(self, height):
        for index in range(0, len(height)):
            if height[index] != 0:
                break
        return index
    def get_end(self, height):
        end = len(height)-1
        for index in reversed(range(0, len(height)-1)):
            if height[index] < height[end]:
                return end
            else:
                end -= 1
        return end

    def trap(self, height: List[int]) -> int:

        if not height: return 0

        volume = 0
        start = self.get_start(height)
        end = self.get_end(height)
        print(f"End: {end}")
        left = start
        right = end
        max_left = height[start]
        max_right = height[end]
        print(f"start: {start}")

        while left < right:
            if max_left <= max_right:
                left +=1
                if height[left] > max_left:
                    max_left = height[left]
                sub_volume = max_left - height[left]
                if sub_volume > 0:
                    volume += sub_volume
            else:
                right -= 1
                if height[right] > max_right:
                    max_right = height[right]
                sub_volume = max_right - height[right]
                if sub_volume > 0:
                    volume += sub_volume

        return volume

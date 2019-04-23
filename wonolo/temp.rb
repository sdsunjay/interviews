# Flatten the Array
# Input: [1, [2, [3, [4]], 5, 6], 7, [8]]
# Output: [1, 2, 3, 4, 5, 6, 7, 8]

# Flatten the array in any way you would like

input_array = [1, [2, [3, [4]], 5, 6], 7, [8]]

def getItems(nums, result)
    if nums.is_a?(Integer)
      result << nums
    elsif nums.is_a?(Array)
        # cut the list
        # set the head and the tail
      getItems(nums[0], result)
      getItems(nums[1..-1], result)
    end
end

def my_flatten_array(input_array)
    result = []
    input_array.each do |element|
        getItems(element, result)
    end
    result
end
p '[1, [2, [3, [4]], 5, 6], 7, [8]]'
p my_flatten_array(input_array)

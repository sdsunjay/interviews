def flatten(input_array):
    result_array = []
    for element in input_array:
        if isinstance(element, int):
            result_array.append(element)
        elif isinstance(element, list):
            result_array += flatten(element)
    return result_array


listMe = [1, [2, [3, [4]], 5, 6], 7, [8]]
print(str(listMe))
flat_list = flatten(listMe)
print(str(flat_list))



def isSubstring(string, substring):
    return substring in string

def is_rotation(s1, s2):
    my_substring = s1
    for chart in s1:
        my_substring = my_substring[1:]
        if my_substring[0] == s2[0]:
            if isSubstring(s2, my_substring):
                newString1 = s1.replace(my_substring, "")
                newString2 = s2.replace(my_substring, "")
                return newString1 == newString2

    return False

string1 = "waterbottle"
string2 = "erbottlewat"
print(f"String 1: {string1}")
print(f"String 2: {string2}")
print(f"Is Rotation: {is_rotation(string1, string2)}")

# https://leetcode.com/problems/longest-common-subsequence/
import timeit
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [dp[:] for dp in [[0] * (len(text2)+1)] * (len(text1) + 1)]
        for i in range(len(text1) - 1, -1, -1):
            for j in range(len(text2) -1, -1, -1):
                if text1[i] == text2[j]:
                    dp[i][j] = 1 + dp[i+1][j+1]
                else:
                    dp[i][j] = max(dp[i][j+1], dp[i+1][j])

        return dp[0][0]

    def longestCommonSubsequence1(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)
        dp = [0] * (n + 1)
        for i in range(m):
            prev = 0
            for j in range(n):
                temp = dp[j + 1]
                if text1[i] == text2[j]:
                    dp[j + 1] = prev + 1
                else:
                    dp[j + 1] = max(dp[j], dp[j + 1])
                prev = temp
        return dp[n]


text1 = "abcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"

text2 = "abcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcde"

s = Solution()
starttime = timeit.default_timer()
print("The start time is :",starttime)
print(f"{s.longestCommonSubsequence('abcde', 'ace')}")
print(f"{s.longestCommonSubsequence('ace','ace')}")
print(f"{s.longestCommonSubsequence('ace', 'def')}")
print(f"{s.longestCommonSubsequence(text1, 'def')}")
print(f"{s.longestCommonSubsequence(text1, text2)}")
print("The time difference is :", timeit.default_timer() - starttime)

starttime = timeit.default_timer()
print("The start time is :",starttime)
print("The start time is :",starttime)
print(f"{s.longestCommonSubsequence1('abcde', 'ace')}")
print(f"{s.longestCommonSubsequence1('ace','ace')}")
print(f"{s.longestCommonSubsequence1('ace', 'def')}")
print(f"{s.longestCommonSubsequence1(text1, 'def')}")
print(f"{s.longestCommonSubsequence1(text1, text2)}")
print("The time difference is :", timeit.default_timer() - starttime)



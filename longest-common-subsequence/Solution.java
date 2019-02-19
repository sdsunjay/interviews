// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
class Solution {
  public static void main(String args[]) {
    String one = new String("abcdaf");
    String two = new String("acbcf");
    output(one, two);
    System.out.println("Expected: 4");
    int longest_common_subsequence = 0;
    longest_common_subsequence = get_longest_common_subsequence(one, two);
    System.out.println("Output: " + longest_common_subsequence);

  }
  private static void output(String one, String two){
    System.out.println("String One: " + one);
    System.out.println("String Two: " + two);
  }
  private static int get_longest_common_subsequence(String one, String two){
    int[][] dp = new int[one.length()+1][two.length()+1];
    int max = recursive(dp, one.toCharArray(), two.toCharArray(), 0, 0, 0);
    return max;
  }
  private static int recursive(int[][] dp, char[] one, char[] two, int i, int j, int max){

    if(i == one.length){
      return 0;
    }
    if(j == two.length){
      return 0;
    }

    if(one[i] == two[j]){
      // dp[i][j] = 1 + dp[i+1][j+1];
      return 1 + recursive(dp, one, two, i+1, j+1, max);
    }
    else {
      dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
      return Math.max(recursive(dp, one, two, i+1, j, max), recursive(dp, one, two, i, j+1, max));
    }
    /**
    if(dp[i][j] > max){
      max = dp[i][j];
    }
    recursive(dp, one, two, i+1, j, max);
    recursive(dp, one, two, i, j+1, max);
    return max;
    */
  }
}

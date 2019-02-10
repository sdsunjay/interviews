//https://leetcode.com/problems/climbing-stairs/
class Solution {
    public static void main(String[] args) throws Exception {
      System.out.println("Input: 6");
      int output = climbStairs(6);
      System.out.println("Expected Output: 13");
      System.out.println("Output: " + output);
    }
    public static int climbStairs(int n) {

        return doRecursion(n, 0, new int[n+1]);

    }
    private static int doRecursion(int n, int total, int[] memo){

        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 3;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        total += doRecursion(n-1, total, memo);
        total += doRecursion(n-2, total, memo);
        memo[n] = total;
        System.out.println("Memo[ " + n + " ] = " + memo[n]);
        return total;
    }
}

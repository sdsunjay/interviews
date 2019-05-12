public class Driver{

  public static void main(String[] args){
    String one = new String("cabcdef");
    String two = new String("cdeefab");
    Solution sol = new Solution(one, two);
    System.out.println("Expected: cde");
    System.out.println("Output: " + sol.longestCommonSubsequence());
  }
}

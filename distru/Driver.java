public class Driver{
  public static void main(String[] args){
    String input = "2 5 +";
    System.out.println("Input: " + input);
    Solution sol = new Solution(input);
    System.out.println("Output: " + sol.rpn());
    System.out.println("Expected: 7");
    input = "2 7 *";
    System.out.println("Input: " + input);
    sol.setInput(input);
    System.out.println("Output: " + sol.rpn());
    System.out.println("Expected: 14");
    input = "1 30 -";
    System.out.println("Input: " + input);
    sol.setInput(input);
    System.out.println("Output: " + sol.rpn());
    System.out.println("Expected: -29");
    input = "3 4 2 * -";
    System.out.println("Input: " + input);
    sol.setInput(input);
    System.out.println("Output: " + sol.rpn());
    System.out.println("Expected: -5");
/**
1 30 -
# result: 1 - 30 = -29

3 6 * 2 /
# result: (3 * 6) / 2 = 9

3 4 2 * -
# result: 3 - (4 * 2) = -5

1
# result: 1
  */
  }
}

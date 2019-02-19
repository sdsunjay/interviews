public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      Counter counter = new Counter();
      for(int i = 0; i < 100; i++){
        counter.hit1();
      }
      System.out.println("Expected: 100");
      System.out.println("Output: " + counter.count1());
      for(int i = 0; i < 10; i++){
        counter.hit();
      }
      System.out.println("Expected: 10");
      System.out.println("Output: " + counter.count());
    }
}

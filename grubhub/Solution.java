import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {

    /*
    String test = new String("racecar");
    boolean flag = isPalindrome(test);
    System.out.println("Output: " + flag);
    test = new String("a b a");
    flag = isPalindrome(test);
    System.out.println("Output: " + flag);
    test = new String("ab a");
    flag = isPalindrome(test);
    System.out.println("Output: " + flag);
    */
    //9009
    //91*99 = 9009
    // xyz * abc = abccba
    boolean found = false;
    int ans;
    int max = 0;
    for(int i = 999; i > 99; i--){
      for(int two = 999; two > 99; two--){
      //999 * 999
      //998 * 999
      //997 * 999
      //996 * 999
      //995 * 999
      //994 * 999
      //993 * 999
      //...
      // 91 * 999
        ans = i * two;

        if(isPalindrome(Integer.toString(ans))){

          //System.out.println(i);
          //System.out.println(two);
          //System.out.println("Largest Palindrome: " + ans);

          if(ans > max){
            max = ans;
          }
        }
      }
    }

    System.out.println(max);
  }
  public static boolean isPalindrome(String s){
    char[] charArray = s.toCharArray();
    int left = 0;
    int right = charArray.length-1;
    while(left < right){
      if(charArray[left] != charArray[right]){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}


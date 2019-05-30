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
    fizzbuzz(100);
  }
  public static void fizzbuzz(int num){
    for(int i = 1; i <= num; i++){
      if(i % 3 == 0 && i % 5 == 0){
        System.out.println("FizzBuzz");
      }
      else if(i % 3 == 0){
        System.out.println("Fizz");
      }
      else if(i % 5 == 0){
        System.out.println("Buzz");
      }
    }
  }
}

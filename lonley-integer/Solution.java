import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  /** Given a number with repeating digits, find the digit that does not repeat
   * EXAMPLE: 392659235 --> ANSWER: 6
   * https://youtu.be/eXWjCgbL01U
   */

  private static int lonelyInteger(int[] array){
    int result = 0;
    for(int value : array){
      result ^= value;
    }
    return result;
  }
  public static void main(String[] args) throws Exception {
    int[] intArray = new int[]{ 3, 9, 2, 6, 5, 9, 2, 3, 5};
    for (int i = 0; i < intArray.length; i++){
      System.out.println("Element at index " + i + " : " + intArray[i]);
    }
    System.out.println("Lonely Integer: " + lonelyInteger(intArray));
  }
}


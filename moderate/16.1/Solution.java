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
    numberSwapper(5, 9);
    numberSwapper(10, 11);
    charSwapper('a', 'b');
    charSwapper('c', 'd');
  }
  public static void numberSwapper(int a, int b){
    System.out.println("Original A: " + a);
    System.out.println("Original B: " + b);
    a = b - a;
    b = b - a;
    a = b + a;
    System.out.println("A: " + a);
    System.out.println("B: " + b);

  }
  public static void charSwapper(int a, int b){
    System.out.println("Original A: " + a);
    System.out.println("Original B: " + b);
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println("A: " + a);
    System.out.println("B: " + b);

  }
}

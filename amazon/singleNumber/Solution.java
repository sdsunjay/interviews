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
    String s = new String("cleetcode");
    int[] nums = new int[]{2, 3, 4, 5, 2, 5, 3};
    System.out.println(Arrays.toString(nums));
    System.out.println(singleNums(nums));
  }
  public static int singleNums(int[] nums){
    HashSet<Integer> set = new HashSet<Integer>();
    for(int i : nums){
      if(set.contains(i)){
        set.remove(i);
      }
      else {
        set.add(i);
      }
    }
    // there should only be one thing in the hashset now
    for(int i: set){
      return i;
    }
    return -1;
  }
}

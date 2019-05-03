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
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.toString(nums));
    System.out.println(binarySearchRecursive(nums, 8, 0, nums.length-1));
    System.out.println(binarySearchIterative(nums, 8));
  }
  public static boolean binarySearchRecursive(int[] array, int x, int left, int right){
    if(left > right){
      return false;
    }
    int mid = (left + right)/2; //could cause int overflow
    if(array[mid] == x){
      return true;
    }
    else if (x < array[mid]){
      return binarySearchRecursive(array, x, left, mid-1);
    }
    return binarySearchRecursive(array, x, mid+1, right);
  }
  public static boolean binarySearchIterative(int[] array, int x){
    int left = 0;
    int right = array.length -1;
    int mid;
    while(left <= right){
      mid = left + ((right - left )/2); //could cause int overflow
      if(array[mid] == x){
        return true;
      }
      else if (x < array[mid]){
        right = mid -1;
      }
      else {
        left = mid + 1;
      }
    }
    return false;
  }
}

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
    System.out.println(firstUniqChar(s));
  }
  public static int firstUniqChar(String s){
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i = 0; i < s.length(); i++){
      char current = s.charAt(i);
      if(!map.containsKey(current)){
        map.put(current, i);
      }
      else {
        map.put(current, -1);
      }
    }
    int min = s.length();
    for(char c : map.keySet()){
      if(map.get(c) != -1 && map.get(c) < min){
        min = map.get(c);
      }
    }
    if(min == s.length()){
      return -1;
    }
    return min;
  }

}

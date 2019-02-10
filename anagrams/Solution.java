import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static int NUMBER_LETTERS = 26;

  /** Given two strings (lowercase a -> z), how many characters do we need to remove
   * (from either) to make them anagrams?
   * EXAMPLE: hello, billion --> ANSWER: 6 ('he' from 'hello' and 'binn' from 'billion')
   * https://youtu.be/3MwRGPPB4tw
   */

  public static void main(String[] args) throws Exception {

    System.out.println("Input first string");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine();
    System.out.println("Input second string");
    String second = br.readLine();
    // Commented out because it is bruteforce
    // But this has more explanation of what is happening
    // System.out.println(numberNeeded(first, second));
    int[] count1 = getCount(first);
    int[] count2 = getCount(second);
    System.out.println(getDifferenceInCounts(count1, count2));

  }

  private static int[] getCount(String one){
    int[] count = new int[26];
    for(char c : one.toCharArray()){
      count[c-'a'] = count[c-'a']+1;
    }
    return count;
  }
  private static int getDifferenceInCounts(int[] count1, int[] count2){
    int difference = 0;
    for(int i = 0; i< 26; i++){
      difference+=Math.abs(count1[i]-count2[i]);
    }
    return difference;
  }
  private static int numberNeeded(String one, String two){
    int counter = 0;
    HashSet<Character> cache_in = new HashSet<Character>();
    HashSet<Character> cache_out = new HashSet<Character>();
    for(char c : one.toCharArray()){
      if(cache_out.contains(new Character(c))){
          System.out.println("Does not contain: " + c);
          counter++;
      }
      else if(!cache_in.contains(new Character(c))){
        if (inString(two,c)){
          cache_in.add(new Character(c));
        }
        else {
          System.out.println("Does not contain: " + c);
          counter++;
          cache_out.add(new Character(c));
        }

      }
    }
    for(char c : two.toCharArray()){
      if(cache_out.contains(new Character(c))){
        System.out.println("Does not contain: " + c);
        counter++;
      }
      else if(!cache_in.contains(new Character(c))){
        if (inString(one,c)){
          cache_in.add(new Character(c));
        }
        else {
          System.out.println("Does not contain: " + c);
          counter++;
          cache_out.add(new Character(c));
        }

      }
    }
    return counter;
  }
  private static boolean inString(String one, char c){
    for(char z : one.toCharArray()){
      if(z == c){
        return true;
      }
    }
    return false;
  }
}

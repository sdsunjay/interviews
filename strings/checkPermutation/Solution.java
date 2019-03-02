import java.util.Arrays;

public class Solution{

    /**
     * Solution 1: Sort the strings, see if they are equal
     */
  public static boolean checkPermutation(String s, String t){
    if (s.length() != t.length()){
      return false;
    }
    return sort(s).equals(sort(t));
  }
  public static String sort(String s){
    char[] content = s.toCharArray();
    // Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations.
    Arrays.sort(content);
    return new String(content);
  }

  /**
   * Solution 2: Check if the two strings have identical character counts
   */
  public static boolean checkPermutationsByCharCount(String s, String t){
    if (s.length() != t.length()){
      return false;
    }
    int[] letters = new int[256]; // Assuming ASCII extended
    char[] s_array = s.toCharArray();
    for(char c: s_array){
      letters[c]++;
    }
    for(int i = 0; i < t.length(); i++){
      int c = (int) t.charAt(i);
      letters[c]--;
      if(letters[c] < 0){
        return false;
      }
    }
    return true;

  }
}

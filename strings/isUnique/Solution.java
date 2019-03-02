// time complexity: O(n), where n is the length of the string
// space complexity: O(1), since the for loop will never iterate through
// more than 256 characters
public class Solution {
  public boolean isUniqueChars(String str){
    // assuming extended ASCII, NOT Unicode
    if(str.length() > 256){
      return false;
    }
    boolean[] char_set = new boolean[256];
    int val;
    for(int i = 0; i < str.length(); i++){
      val = str.charAt(i);
      if(char_set[val]){ // Already found this char in string
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }
}
// we can reduce our space complexity by a factor of 8 by using a bit vector
// this would allow us to use just a single int, instead of a boolean array


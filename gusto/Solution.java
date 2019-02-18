import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
// Problem
// Given an input string and a list of substrings to bold, return the same input string with HTML bold tags <b> and </b> around the substrings which are found in the input string.
/**

  Problem
  Given an input string and a list of substrings to bold, return the same input string with HTML bold tags <b> and </b> around the substrings which are found in the input string.

  embolden_substrings('abcxyz', [])
  'abcxyz'

  embolden_substrings('abcxyz', ['abc'])
  '<b>abc</b>xyz'

  embolden_substrings('abcxyz123', ['abc', '123'])
  '<b>abc</b>xyz<b>123</b>'
  If two substrings overlap, both substrings must be encapsulated by bold tags.

  embolden_substrings('abcdxyz1234abc', ['abc', '123', 'bcd'])
  '<b>abcd</b>xyz<b>123</b>4<b>abc</b>'
  012345678
  embolden_substrings('yxxxyyxxx', ['xx', 'xy'])
  'y<b>xxxy</b>y<b>xxx</b>'
  1. <b>xx</b><b>xy</b>


  2. [1,2]
  3. [2,3]
  [1,3]
  4. [6,7]
  5. [7,8]
  [6,8]
  6. 3,4
  [1,4] [6,8]

  [0,1,2,3,4,5,6,7,8]
  0 0 0 0 0 0 0 0 0
  1 1
  1 1
  0 1 1 1
  7. 1,2,3
  8. 1,2,3,4
  9. 6,7,8
  <b>1,2,3,4</b>5<b>6,7,8</b>

  If two substrings are adjacent, the tags must encapsulate both of them, but it can be done together or separately.

  embolden_substrings('abcxyz', ['abc', 'xyz'])
  '<b>abcxyz</b>'
  OR

  embolden_substrings('abcxyz', ['abc', 'xyz'])
  '<b>abc</b><b>xyz</b>'

*/

class Solution {
  public static void main(String[] args) {
    String one = new String("abcdxyzdabc");

    //String[] substrings = new String[]{"abc","b","c"};
    String[] substrings = new String[]{"abc", "xyz"};
    printStrings(one, substrings, new String("<b>abc</b>d<b>xyz</b>d<b>abc</b>"));
    System.out.println(embolden_substrings(one, substrings));
    one = new String("abcxyzabc");
    printStrings(one, substrings, new String("<b>abcxyzabc</b>"));
    System.out.println(embolden_substrings(one, substrings));

  }
  public static void printStrings(String one, String[] substrings, String output){

    System.out.println("String: " + one);
    System.out.println("Substrings: ");
    for(int i = 0; i< substrings.length; i++){
     System.out.println(substrings[i]);
    }
    System.out.println("Expected output: " + output);
  }

  //public void embolden_substrings('abcxyz', ['abc', ]){
  // 'abc' ['xx']
  // 'yxxxyyxxx', ['xx', 'xy'])
  public static String embolden_substrings(String one, String[] substrings){
    //step 1: look through the string, see where we have matches
    int[] collisions = new int[one.length()];
    int value, i;
    int startIndex = 0;
    for(i = 0;i<substrings.length; i++){
      value = 0;
      startIndex = 0;
     // keep looking for the substring until there is nothing found
      while(value != -1){
        value = one.indexOf(substrings[i], startIndex);
        // did we find the substring
        if(value != -1){
          for(int j = value; j< value + substrings[i].length(); j++){
            collisions[j] = 1;
            startIndex++;;
          }
        }
      }
    }
    StringBuilder bold_str = new StringBuilder();
    System.out.println("Collisions array: " + Arrays.toString(collisions));
    System.out.print("Output: ");
    for(i = 0; i < collisions.length; i++){
      if(collisions[i] == 1){
        bold_str.append("<b>");
        while( i < collisions.length && collisions[i] == 1){
          bold_str.append(one.charAt(i));
          i++;
        }
        bold_str.append("</b>");
      }
      if(i < collisions.length)
        bold_str.append(one.charAt(i));
    }
    return new String(bold_str);
  }
}

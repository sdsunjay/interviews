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
    String[] book = new String[]{"some", "test", "words", "that", "appear", "often", "than", "some"};
    String word = new String("some");
    int count = getFrequency(book, word);
    System.out.println(word + " : " + count);
    HashMap<String, Integer> map =  setupDictionary(book);
    count = getFrequency(map, word);
    System.out.println(word + " : " + count);
  }
  /**
   * Solution for a Single Query
   */
  public static int getFrequency(String[] book, String word){
    word = word.trim().toLowerCase();
    int count = 0;
    for(String w : book){
      if(w.trim().toLowerCase().equals(word)) {
        count++;
      }
    }
    return count;
  }
  private static HashMap<String, Integer> setupDictionary(String[] book){
    HashMap<String, Integer> table = new HashMap<String, Integer>();
    for(String word : book){
      word = word.toLowerCase();
      if(word.trim() != ""){
        if(!table.containsKey(word)){
          table.put(word, 0);
        }
        table.put(word, table.get(word) + 1);
      }
    }
    return table;
  }
  /**
   * Solution for Repetitive Queries
   */
  public static int getFrequency(HashMap<String, Integer> table, String word){
    if(table == null || word == null){
      return -1;
    }
    word = word.toLowerCase();
    if(table.containsKey(word)){
      return table.get(word);
    }
    return 0;
  }
}

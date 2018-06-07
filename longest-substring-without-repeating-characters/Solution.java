// longest-substring-without-repeating-characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int temp_count = 0;
        int final_count = 0;
        int size = 256;
        int index = 0;
        int temp = 0;
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        boolean[] table = new boolean[size];
        if(s == null || s.isEmpty()){
            return 0;
        }
        for(int i = 0; i < s.length(); i++){
            //System.out.println("Index: " + i);
            //System.out.println("Character: " + s.charAt(i));
            index = s.charAt(i) - ' ';
            if(ht.containsKey(new Integer(index)) == false){
                ht.put(index, i);
                //System.out.println("Never Seen");
                //never seen this letter
                temp_count++;
            } else {
                //System.out.println("Seen");
                // seen before
                if(temp_count > final_count)
                    final_count = temp_count;
                temp_count = 0;

                Integer start = ht.get(index);
                // move back in time
                temp = start.intValue();
                if(s.length() - (temp + 1) > final_count){
                    i = temp;
                }
                // clear the table
                ht.clear();
            }
        }
        if(temp_count > final_count){
            // all characters were unique
            final_count = temp_count;
        }
        return final_count;

    }
}

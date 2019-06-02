import java.util.Hashtable;
class Solution {
    public int solution(int[] T) {
        int n = T.length;
        // give away
        int give_away = n/2;
        int unique = 0;
        int duplicates = 0;
        // creating a hash table
        Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();
        for(int i = 0; i < n; i++){
            Integer val = h.get(T[i]);
            if(val == null) {
                unique++;
                val = new Integer(0);
            } else {
                duplicates++;
            }
            ++val;
            h.put(T[i], val);
        }
        if(duplicates < give_away){
            int temp = give_away - duplicates;
            int result = unique - temp;
            //System.out.println("result: " + result);
            return result;
        }
        return unique;

    }
}

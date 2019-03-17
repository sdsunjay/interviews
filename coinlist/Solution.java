import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;
public class Solution{
// Complete the electionWinner function below.
    public static String electionWinner(String[] votes) {
         ArrayList<String> winners = new ArrayList<String>(votes.length);
         Hashtable<String, Integer> table = new Hashtable<String, Integer>();
         int numberOfVotes = 0;
         for (String name : votes){
             if(table.containsKey(name)){
                 numberOfVotes = table.get(name);
                 numberOfVotes++;
                 table.put(name, Integer.valueOf(numberOfVotes));
             }
             else{
                 table.put(name, Integer.valueOf(1));
             }

         }
         Set<String> keys = table.keySet();
         int winningVotes = 0;
         int voteCount;
         for(String key: keys){
            voteCount = table.get(key);
             System.out.print(key + " : " + voteCount);
             if(voteCount > winningVotes){
                 // remove all existing
                 winners.clear();
                 winners.add(key);
                 winningVotes = voteCount;
             }
             else if(voteCount == winningVotes){
                winners.add(key);
             }
         }
         int size = winners.size();
         if( size > 1){
             Collections.sort(winners);
         }
         System.out.println(winners);
         return winners.get(size-1);
     }
    public static void main(String[] args){
      String[] votes = new String[]{"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
      System.out.println(electionWinner(votes));
      votes = new String[]{"Victor", "Alex", "Alex", "Michael", "Michael", "Harry", "Dave", "Dave", "Michael", "Victor", "Victor", "Harry", "Alex", "Mary", "Mary", "Harry"};
      System.out.println(electionWinner(votes));
    }
}

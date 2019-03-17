import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
class Result {

    /*
     * Complete the 'getMinimumUniqueSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int getMinimumUniqueSum(List<Integer> arr) {
    // Write your code here
        Set<Integer> uniq = new TreeSet<Integer>();
        for(int i = 0; i < arr.size(); i++){
            Integer item = arr.get(i);
            if(uniq.contains(item)){
                uniq.add(helpGetMinimumUniqueSum(uniq, item));
            }
            else{
                uniq.add(item);
            }
        }
        return sumOfSet(uniq);

    }
    private static Integer helpGetMinimumUniqueSum(Set<Integer> uniq, Integer item){
        int temp = item.intValue();
        while(uniq.contains(Integer.valueOf(temp))){
            temp++;
        }
        return Integer.valueOf(temp);
    }
    private static int sumOfSet(Set<Integer> uniq){
        Iterator<Integer> it = uniq.iterator();
        int sum = 0;
        while (it.hasNext()) {
           sum += it.next();
        }
        return sum;
    }
}

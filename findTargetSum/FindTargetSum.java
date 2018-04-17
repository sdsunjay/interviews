import java.util.*;
import java.util.HashMap;
public class FindTargetSum
{
    public static int[] findTargetSum(int[] nums, int target){
        if (nums == null)
            return null;
        int ret[] = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(target-nums[i],i);
            if(map.containsKey(nums[i])){
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                break;
            }
        }
        return ret;
    }
}

public class SearchInsert{
    public static int searchInsert(int[] nums, int target){
        if( nums == null || nums.length == 0)
            return 0;
        return searchInsert(nums, target, 0, nums.length-1);
    }
    private static int searchInsert(int[] nums, int target, int start, int end){
        int mid = (start + end)/2;
        if(target == nums[mid])
            return mid;
        else if (target < nums[mid]){
            if((mid-1) < start)
                return start;
            else
                return searchInsert(nums,target,start,mid-1);
        }
        else{
            if((mid+1) > end)
                return end;
            else 
                return searchInsert(nums,target,mid+1,end);
        }
    }
}

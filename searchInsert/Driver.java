public class Driver{
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println("Nums: ");
        for(int i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }
        System.out.println("Target "+ target);
        int result = SearchInsert.searchInsert(nums,target);

        System.out.println("Index for insert of target: \n"+ result);
    }
    
}

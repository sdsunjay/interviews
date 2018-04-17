public class Driver{
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 13;
        System.out.println("Nums: ");
        for(int i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }
        System.out.println("Target "+ target);
        int[] result = FindTargetSum.findTargetSum(nums,target);

        System.out.println("Indices: \n"+ result[0] + "\n"+ result[1]);
    }
    
}

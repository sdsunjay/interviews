public class Driver
{


public static void main(String[] args) {
    	int[] intArr={3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
        MaxSubSequence maxSubSequence = new MaxSubSequence(intArr);
	System.out.println(maxSubSequence.maxSubSequence());	
}
}

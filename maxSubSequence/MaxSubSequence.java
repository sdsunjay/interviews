// LinkedIn Interview
public class MaxSubSequence{

	int[] a;
	public MaxSubSequence(int[] a)
	{
		this.a= a;
	}	
	/** 
 	* Finds the subsequence which produces the max sum 
 	* @return the max sum
 	*
 	*/	 
	public int maxSubSequence()
	{
		int currentMax = 0;
		int max = 0; 
		int startIndex;
		int endIndex;
		int currentStartIndex = 0;
		for(int i =0; i< a.length; i++)
		{
			currentMax += a[i];
			if(currentMax >= max)
			{
				max = currentMax;
				endIndex = i;
				//not sure about this line
				startIndex= currentStartIndex; 
			}
			if(currentMax < 0)
			{
				if(i+1 < a.length)
				{
					currentStartIndex=i+1;
		            	}
				currentMax=0;

			}
		}
		return max;
	}

}

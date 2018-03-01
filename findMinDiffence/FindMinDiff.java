// LinkedIn Interview
public class FindMinDiff
{

	int[] a;
	int[] b;
	public FindMinDiff(int[] a,int[] b)
	{
	//both of these int arrays are sorted in ascending order
		this.a = a;
		this.b = b;
	}
	public int findMinDiff()
	{
		int minDiff;
		//set minDiff to last element in first array
		//Obviously we can do better than that
		minDiff = a[a.length-1];
		int i, j;
		i=j=0;
		while (i < a.length && j < b.length) 
		{
			if (a[i] <= b[j]) 
			{ 
				minDiff = Math.min(minDiff, b[j]-a[i]); i++; 
			} 
			else 
			{ 
				minDiff = Math.min(minDiff, a[i]-b[j]); j++; 
			}
		}
		return minDiff;

		//

	}
}

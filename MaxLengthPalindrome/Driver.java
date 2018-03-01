// LinkedIn Interview
import java.util.*;
public class Driver
{
	public static int maxLengthPalindrome(Subint[] values)
	{
		int result = 0;
		Hashtable ht = new Hashtable();	
		for(int i = 0; i < values.length; i++)
		{
			if(ht.containsKey(values[i]))
			{
				result+=2;
				ht.remove(values[i]);
			}
			else
			{
				ht.put(values[i],new Integer(0));
			}
		}
		return result;
	}
	public static void main(String[] args)
	{
		int arr[] = new int[] {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};	
		System.out.println(maxLengthPalindromeSub(arr));
	}

}

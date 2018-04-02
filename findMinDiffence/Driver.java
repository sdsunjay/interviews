public class Driver
{


	public static void main(String[] args)
	{
		int[] a = {1,2,3,4,5};
		int[] b = {6,7,8,9,10};
		FindMinDiff findMinDiff = new FindMinDiff(a,b);
		System.out.println("Expected: 1");
		System.out.println(findMinDiff.findMinDiff());
		int[] c = {6,7,8,9,10};
		int[] d = {1,2,3,4,5};
		findMinDiff = new FindMinDiff(c,d);
		System.out.println("Expected: 1");
		System.out.println(findMinDiff.findMinDiff());
		int[] e = {1,5,9,10};
		int[] f = {7,13,19};
		findMinDiff = new FindMinDiff(e,f);
		System.out.println("Expected: 2");
		System.out.println(findMinDiff.findMinDiff());
	}
}

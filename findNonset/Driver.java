public class Driver 
{

	public static void main(String[] args)
	{
		Integer[] intList = new Integer[] {1,2,3,4,5,6,7,1,2,3,4,6,7};
		System.out.println("Expected: 5");
		findNonset findMe = new findNonset(intList);
		System.out.println(findMe.easySolution());
		System.out.println(findMe.hardSolution());

	}

}

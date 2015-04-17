public class Driver
{
	public static void main(String[] args)
	{
		Anagrams anagrams = new Anagrams("thesestringsarethesame","thesestringsarethesame");
	//let people know the two strings we are comparing
		System.out.println(anagrams.toString());
		//check is they are anagrams
		if(anagrams.checkAnagrams())
		{
			System.out.println("These strings are the same.");
		}
		else
		{
			System.out.println("These strings are not the same.");
		}
	}

}

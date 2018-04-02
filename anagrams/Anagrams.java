import java.util.Arrays;
public class Anagrams{

	//the string can only be lower case letters
	private static final int NUM_CHARACTERS = 26;
	
	private String one;
	private String two;
	public Anagrams(String one, String two)
	{
		this.one = one;
		this.two = two;
	}
	public String toString()
	{
		return "String 1: " + one + "\nString 2: "+two;
	}
	public boolean checkAnagrams()
	{
		int[] count1 = new int[NUM_CHARACTERS];		
		int[] count2 = new int[NUM_CHARACTERS];		
		
		//compare the strings length
		if(one.length() != two.length())
			return false;
		//iterate through strings and get character counts
		for(int i = 0; i<one.length(); i++)
		{
			count1[one.charAt(i)-'a']++;
			count2[two.charAt(i)-'a']++;
		}
		//compare character counts for each string
		/*for(int i = 0;i<NUM_CHARACTERS;i++)
		{
			if(count1[i]!=count2[i])
			{
				return false;
			}
		}
       
		//the strings must have had the same counts
		return true;
        */
        return Arrays.equals(count1,count2);
	}

}

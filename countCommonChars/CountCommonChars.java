// LinkedIn
import java.util.*;
public class CountCommonChars
{
	String[] strings;
	public CountCommonChars(String[] strings)
	{
		this.strings = strings;
	}
	public int countCommonChars()
	{
		int returnValue = 0;
		int[] charCounts = new int[26]; 
		for(int i = 0; i < strings.length; i++)
		{
			Set<Character> hs = new HashSet<Character>();
			for(int j = 0; j < strings[i].length(); j++)
			{
				char c = strings[i].charAt(j);
				if(!hs.contains(c))
				{
					hs.add(c);
					//Count the unique characters in each word 
				        charCounts[c-'a']+=1;	
				}
				
			}
		}
		for(int i =0; i<26;i++)
		{
			//did the letter appear in all strings?
			if(charCounts[i]==strings.length)
			{
				returnValue++;
			}
		}
		return returnValue;
	}
}

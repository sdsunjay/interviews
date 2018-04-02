// LinkedIn Interview
import java.util.*;
public class Iso
{
	
//app 

	public boolean iso(String one, String two)
	{
		Hashtable ht1 = new Hashtable();
		Hashtable ht2 = new Hashtable();
		int index = 0;
		for(char c: one.toCharArray())
		{
			if(!ht1.containsKey(two.charAt(index)))
				ht1.put(c,two.charAt(index));
			index++;
		}
		index=0;
		for(char c: two.toCharArray())
		{
			if(!ht2.containsKey(one.charAt(index)))
			ht2.put(c,one.charAt(index));
			index++;
		}
		for(int i = 0 ; i < one.length(); i ++)
		{
			if(!ht1.get(one.charAt(i)).equals(new Character(two.charAt(i))))
			{
				System.out.println(ht1.get(one.charAt(i)));
				System.out.println(new Character(two.charAt(i)));
				return false;
			}
			
		}
		return true;
	}
}

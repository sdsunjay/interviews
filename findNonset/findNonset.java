// LinkedIn Interview
import java.util.*;
public class findNonset
{
	Integer[] array;
	public findNonset(Integer[] array )
	{
		this.array = array;
		
	}

	public Integer easySolution()
	{

		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>(array.length);
		for(int i = 0; i < array.length ; i++)
		{
			if(!table.containsKey(array[i]))
			{
				table.put(array[i],array[i]);
			}
			else
			{
				table.remove(array[i]);
			}
		}
		Collection<Integer> myCollection = table.values();
		
		return (Integer) myCollection.toArray()[0];

	}
	/*
	public Integer mediumSolution()
	{
		Hashset<Integer,Integer> table = new Hashset<Integer,Integer>(array.length);
		for(int i = 0; i < array.length ; i++)
		{
			if(!table.containsKey(array[i]))
			{
				table.put(array[i],array[i]);
			}
			else
			{
				table.remove(array[i]);
			}
		}
		Collection<Integer> myCollection = table.values();
		
		return (Integer) myCollection.toArray()[0];
	
	}*/
	public Integer hardSolution()
	{
		Integer result;
		result = 0;
		for(int i = 0; i < array.length ; i++)
		{
			result^=array[i];
		}
		return result;

	}

}

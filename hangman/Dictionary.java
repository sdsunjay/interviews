import java.lang.*;
import java.util.*;
import java.io.*;
public class Dictionary
{
	String filename;
	ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>(10);
	int start;
	int end;
	//what we will be returning
	//Array Of characters being stored
	ArrayList<Character> characters;
	//   List<List<String>> words = new ArrayList<>();
		//@SuppressWarnings("unchecked")
		//Hashtable<LetterPosition,ArrayList<Character>>[] h = (Hashtable<LetterPosition,ArrayList<Character>>[])new Hashtable<?,?>[10];
	Hashtable<LetterPosition,ArrayList<Character>> table =new Hashtable<LetterPosition,ArrayList<Character>>();
	char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	LetterPosition lp; 
	public Dictionary(String filename,int start,int end)
	{
		this.filename=filename;
		this.start = start;
		this.end = end;
		//for words length 5-15
		//key is letter and placement
		//Example A+0 would be 'A' in the first position
		for(int i =start;i<end;i++)
		{	 

			//	 h[i] = new Hashtable<LetterPosition,ArrayList<Character>>();
			//our fake dictionary will start only having 100 words of each length.
			words.add(new ArrayList<String>(100));
		}
	}
	public String toString()
	{
		String ret ="";
		ret+= table.toString();
		ret+= "\n\n";
		return ret;
	}
	public void parseDictionary()
	{
		// Location of file to read
		File file = new File(filename);

		try {
			//length of word
			int length;

			Scanner scanner = new Scanner(file);
			String word;
			ArrayList<String> test;
			while (scanner.hasNext()) {
				//get the next word from the dictionary
				word=scanner.next();
				length = word.length();
				if(length >= start && length < end)
				{
					test = words.get(length-start);
					word = word.toLowerCase();
					test.add(word);
				}
			}
			scanner.close();

			//for word of length start to end
			for(int i =start;i<end;i++)
			{
				test = words.get(i-start);
				if(test == null)
				{
					System.err.println("ERROR - No words!\n");

				}
				else
				{
					addToHashTable(test,i);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void zeroCount(int[] counts)
	{
		for(int i=0;i<counts.length;i++)
		{
			counts[i] = 0;
		}
	}
	private void printCount(int[] counts)
	{
		for(int i=0;i<counts.length;i++)
		{
			System.out.println("Count for "+c[i]+" is "+counts[i]);
		}
	}
	public void addToHashTable(ArrayList<String> someWords,int length)
	{
		//each word length with a letter at that position has its own count
		int[] counts;
		counts = new int[26];


		//for each letter
		for(int letter=0;letter<26;letter++)
		{
			//for each position in the word
			for(int position=0;position<length;position++)
			{
				zeroCount(counts);
				//find the most common letters
				counts = findMostCommonLetters(letter,length,position,counts);

				lp = new LetterPosition(c[letter],position,length);
				//System.out.println("Added: "+lp.toString());
				//System.out.println("Most common letters are: "+temp.toString());
				helpFindMostCommonLetters(counts);
				table.put(lp,characters);
				/*  if(lp.equals(new LetterPosition('*',0)))
				    {
				    System.out.println("length: "+length);
				    System.out.println(lp);
				    System.out.println("FOUND");
				    }*/
			}
		}
		//total counts for each word length
		lp = new LetterPosition('*',0,length);
		//System.out.println("Length"+ length);
		//zeroCount(counts);
		counts=findMostCommonLetters(someWords,counts);
		helpFindMostCommonLetters(counts);
		table.put(lp,characters);
		//   System.out.println("get from hashtable: ");
		// System.out.println(h.get(lp));

		//lp = new LetterPosition('*',0,length);
		System.out.println("LOOK UP for word of "+length+" characters: ");
		System.out.println(lookUp(lp,0));
	}


	public List lookUp(LetterPosition l,int guess)
	{
		if(table.containsKey(l))
		{
			return table.get(l);
		}
	
	//	return new Character('-');
		return null;

	}

	public int[] findMostCommonLetters(ArrayList<String> someWords,int[] counts)
	{
		//loop counter;
		int i;

		//iterate through all words of that size
		for(i=0;i<someWords.size();i++)
		{
			counts=handleWord(someWords.get(i),counts);
		}
		//printCount(counts);
		return counts;
	}

	public int[] findMostCommonLetters(int letter,int length,int position,int[] counts)
	{
		//loop counter;
		int i;

		//get the arraylist of words with the word length we care about
		ArrayList<String> s =(ArrayList<String>) words.get(length-start);
		//iterate through all words of that size


		for(i=0;i<s.size();i++)
		{
			String word = s.get(i);
			if(word.charAt(position)==c[letter])
			{
				//add letters to counts;
				counts=handleWord(word,counts);
			}
		}
		//printCount(counts);
		return counts;
	}
	private void helpFindMostCommonLetters(int[] counts)
	{
		//assignment
		characters = new ArrayList<Character>();

		//the temp most common letter
		char mostCommon;
		//find 26 characters with the most common appearances
		//store them in order 
		for(int i=0;i<counts.length;i++)
		{
			mostCommon=findMax(counts);
			Character commonCharacter = new Character(mostCommon);
			//add that character to the arraylist
			characters.add(commonCharacter);
			//remove that most common character from the count;	 
			counts[mostCommon-97]=0;
		}
		//System.out.println(characters.toString());
		//System.exit(0);
		//return characters;
	}

	//find the most common letters for each letter in each position

	public int[] handleWord(String word,int[] counts)
	{
		int index;
		for(int i =0;i<word.length();i++)
		{
			index = word.charAt(i)-97;
			if(index >=26)
			{
				System.err.println("ERROR\n");
			}
			else
			{
				//we only look at lower case words
				counts[index]++;
			}
		}
		return counts;
	}
	private char findMax(int[] counts)
	{
		int temp;
		int character;
		character =0;
		temp = 0;
		//store the 26 most common letters in order
		for(int i =0;i<counts.length;i++)
		{
			// a semicolon at the end of this line screwed things up..be careful
			if(counts[i]>=temp)
			{
				temp=counts[i];
				character = i;

			}

		}
		//System.out.println("Most common character is "+c[character]);
		//System.out.println("appeared "+temp);
		return c[character];
	}
}

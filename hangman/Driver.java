import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver
{
   public static void main(String[] args)
   {
      int length;
      Character letter;
      String filename = "create.txt";
      int lengthOfShortestWord = 5;
      int lengthOfLongestWord = 6;
      Dictionary d = new Dictionary(filename,lengthOfShortestWord,lengthOfLongestWord);
      d.parseDictionary();
      //System.out.println(d.toString(5));
   //   System.out.println("Enter your length of word.");
     // Scanner input = new Scanner(System.in);
     //length = input.nextInt();
     	length = 5;

      LetterPosition LP = new LetterPosition('*',0,length);
     //letter = d.lookUp(LP,0);
     System.out.println(d.lookUp(LP,0));
     //System.out.println("Is " ++ " in your word? (1 - yes) ");
     int answer;
     //answer = input.nextInt();
     int guess;
     guess =0;
/*
     do{
	if(answer == 1)
	{
	   System.out.println("Where is that character located? (starting with 0)");
	 //  answer = input.nextInt();
	   //LP = new LetterPosition(letter.charValue(),answer,length);
	   //letter = d.lookUp(LP,guess);
	   //System.out.println("Is the letter " +letter+ " in your word? (1 - yes) ");
	  // answer = input.nextInt();
	}
	else
	{

	}
	System.out.println("Quit? ( 1 - yes)");
        answer = input.nextInt();
	if(answer == 1)
	{
	   break;
	}
	guess++;
     }
     while(true); 
*/
	//System.out.println("most common letters with 'c' in the first position for strings of length 5 ");

	//System.out.println(temp.toString());
   }
}

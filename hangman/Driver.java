import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver
{
    public static void main(String[] args)
    {
        int length;

        int guess;
        Character letter;
        // String filename = "create.txt";
        String filename = "3letter.txt";

        Scanner input = new Scanner(System.in);
        //System.out.println(d.toString(5));
        System.out.println("Enter your length of word.");
        length = input.nextInt();

        int lengthOfShortestWord = 3;
        int lengthOfLongestWord = 4;
        Dictionary d = new Dictionary(filename,lengthOfShortestWord,lengthOfLongestWord);
        d.parseDictionary();
        guess = 0;

        LetterPosition LP = new LetterPosition('*',0,length);
        letter = d.lookUp(LP,0);

        int answer;
        do{
            //System.out.println("Lookup for words of "+length+" :"+d.lookUp(LP,0));
            System.out.println("Is " + letter + " in your word? (1 - yes, 0 - no, -1 - quit) ");
            if (input.hasNextInt()){
                answer = input.nextInt();
            } else {
                input.next();
                continue;
            }
            if(answer == 1){
                do{
                    System.out.println("In which position does that character appear? (starting with 0)");
                    if (input.hasNextInt()){
                        answer = input.nextInt();
                        LP = new LetterPosition(letter.charValue(),answer,length);
                        guess = 1;
                        letter = d.lookUp(LP,guess);
                    } else {
                        input.next();
                        continue;
                    }
                    System.out.println("Is that it? (1 - yes, 0 - no, -1 - quit) ");
                    if (input.hasNextInt()){
                        answer = input.nextInt();
                    }
                }while(answer ==0);
            } else if (answer == 0) {

                guess++;
                letter = d.lookUp(LP,guess);
            }
            //System.out.println("Quit? ( 1 - yes)");
            //answer = input.nextInt();
            if(answer == -1) {
                break;
            }
        }
        while(true);
        //System.out.println("most common letters with 'c' in the first position for strings of length 5 ");

        //System.out.println(temp.toString());
    }
}

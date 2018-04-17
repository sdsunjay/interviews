import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class SortString {
    public static String sortString(String inputString){
        //convert input string to char array
        char tempArray[] = inputString.toCharArray();
        //sort tempArray
        Arrays.sort(tempArray);

        return new String(tempArray);
    }
    public static char[] quickSort(char[] tempArray, int length, Random rand){
        int  pivot = rand.nextInt(tempArray.length-1);
        if (tempArray.length == 1)
            return tempArray;
        for(int i = 0; i < tempArray.length; i++){
            if(tempArray[i] < tempArray[pivot] && i > pivot) {
               System.out.println(tempArray[i] + "is less than" + tempArray[pivot]);
                System.out.println("move element to new place");
            } else if(tempArray[i] > tempArray[pivot] && i < pivot) {
                System.out.println(tempArray[i] + "is greater than" + tempArray[pivot]);
                System.out.println("move element to new place");
            }
            //break array in half and call again
            length = tempArray.length/2;
            quickSort(tempArray, length, rand);
        }
        return null;
    }
    /**
     * Sort a mixed String using Sunjay quicksort
     * @param inputString - the string to sort
     */
    public static String sortString1(String inputString){

        //convert input string to char array
        char tempArray[] = inputString.toCharArray();
        // Randomly pick pivot

        Random rand = new Random();
        tempArray = quickSort(tempArray, tempArray.length-1, rand);
        return "HELLO";
    }

    // Driver Method
    public static void main(String[] args){
        String inputString;
        String outputString;
        if (args.length > 0){
            inputString = args[0];
        } else {
            System.out.println("Enter input string");
            Scanner in = new Scanner(System.in);
            inputString = in.next();
        }
        outputString = sortString(inputString);
        System.out.println("Input String: " + inputString);
        System.out.println("Sorted String: " + outputString);
    }
}

public class Solution{

    public String runlength_encode(String initial_string){

        String return_string = new String();
        int count = 0;
        char c = ' ';
        char[] char_array = initial_string.toCharArray();
        int i = 0;

        while(i < char_array.length){
            c = char_array[i];

            count = countEachLetter(i, char_array, c);
            // this isn't syntatically correct
            return_string += Integer.toString(count) + Character.toString(c);

            i += count;


        }
        return return_string;

    }


    private int countEachLetter(int i, char[] char_array, char c){
        int count = 0;
        while(i < char_array.length && char_array[i] == c){
            count++;
            i++;
        }
        return count;
    }
}

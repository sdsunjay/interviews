public class ReverseString{

    public static String reverseString(String s){
        if(s == null)
            return "";
        int left = 0;
        int right = s.length()-1;
        char[] input = s.toCharArray();
        while(right>left){
            char c = input[right];
            input[right] = input[left];
            input[left] = c ;
            left++;
            right--;
        }
        return String.valueOf(input);
    }
    public static String reverseStringRecursively(String s){
        if(s.length() == 0)
            return s;
        return reverseStringRecursively(s.substring(1)) + s.charAt(0);
    }
}

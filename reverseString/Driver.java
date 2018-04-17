public class Driver{
    public static void main(String[] args){
        String s = "sunjay"; 
        System.out.println("Original String: " + s);
        String result = ReverseString.reverseString(s);
        System.out.println("Reversed String: " + result);
        System.out.println("Original String: " + s);
        result = ReverseString.reverseStringRecursively(s);
        System.out.println("Recursively Reversed String: " + result);

    }
    
}

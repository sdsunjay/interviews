public class Driver{
    public static void main(String[] args) {
        String s;
        Solution sol = new Solution();
        int length_of_longest = 0;
        s = new String("abcabcbb");
        System.out.println("Test String: " + s);
        length_of_longest = sol.lengthOfLongestSubstring(s);
        System.out.println(length_of_longest);
        System.out.println("Expected: 3");
        s = new String("bbbbb");
        System.out.println("Test String: " + s);
        length_of_longest = sol.lengthOfLongestSubstring(s);
        System.out.println(length_of_longest);
        System.out.println("Expected: 1");
        s = new String("dvdf");
        System.out.println("Test String: " + s);
        length_of_longest = sol.lengthOfLongestSubstring(s);
        System.out.println(length_of_longest);
        System.out.println("Expected: 3");
        s = new String("abcdeefghijaekl");
        System.out.println("Test String: " + s);
        length_of_longest = sol.lengthOfLongestSubstring(s);
        System.out.println(length_of_longest);
        System.out.println("Expected: 9");
    }
}

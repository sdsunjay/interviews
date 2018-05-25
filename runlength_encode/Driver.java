public class Driver{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Input: aabbbcaa");
        System.out.println("Expected: 2a3b1c2a");
        System.out.println(sol.runlength_encode("aabbbcaa"));
    }
}

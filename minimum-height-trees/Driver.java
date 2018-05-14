public class Driver{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = { {1,0}, {1, 2}, {1, 3}};
        int N = 4;
        System.out.println("N = " + N);
        System.out.println("Expected: 1");
        System.out.println(sol.findMinHeightTrees(N, edges));
    }
}

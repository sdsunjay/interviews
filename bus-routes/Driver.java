public class Driver{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] routes={ {1,2, 7}, {3, 6, 0}, {2, 3, 9}, {7, 5, 11} };
        int S = 1;
        int T = 6;
        //expected 3
        sol.numBusesToDestination(routes, S, T);
        System.out.println();
        System.out.println();
        int[][] routes1={ {1,2, 7}, {3, 6, 0}, {2, 11, 9}, {7, 5, 11}, {4, 5, 11}, {5, 9, 12}, {12, 4, 19} };
        S = 1;
        T = 6;
       //expected -1
        sol.numBusesToDestination(routes1, S, T);
        System.out.println();
        System.out.println();
        int[][] routes2={ {1,2, 7}, {3, 6, 0}, {2, 11, 9}, {7, 5, 11}, {4, 5, 11}, {5, 9, 12}, {12, 4, 3} };
        S = 1;
        T = 6;
        //expect 5
        sol.numBusesToDestination(routes2, S, T);

//    [[1,9,12,20,23,24,35,38],[10,21,24,31,32,34,37,38,43],[10,19,28,37],[8],[14,19],[11,17,23,31,41,43,44],[21,26,29,33],[5,11,33,41],[4,5,8,9,24,44]]
//S = 37
//T = 28
//expects 1
    }
}

public class Driver{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] routes={ {1,2, 7}, {3, 6, 0}, {2, 3, 9}, {7, 5, 11} };
        int S = 1;
        int T = 6;
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        System.out.println("Expected: 3");
        System.out.println(sol.numBusesToDestination(routes, S, T));
        System.out.println();
        System.out.println();
        int[][] routes1={ {1,2, 7}, {3, 6, 0}, {2, 11, 9}, {7, 5, 11}, {4, 5, 11}, {5, 9, 12}, {12, 4, 19} };
        S = 1;
        T = 6;
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        System.out.println("Expected: -1");
        System.out.println(sol.numBusesToDestination(routes1, S, T));
        System.out.println();
        System.out.println();
        int[][] routes2={ {1,2, 7}, {3, 6, 0}, {2, 11, 9}, {7, 5, 11}, {4, 5, 11}, {5, 9, 12}, {12, 4, 3} };
        S = 1;
        T = 6;
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        System.out.println("Expected: 5");
        System.out.println(sol.numBusesToDestination(routes2, S, T));
        System.out.println();
        System.out.println();
        int[][] routes3 = { {1,9,12,20,23,24,35,38},{10,21,24,31,32,34,37,38,43},{10,19,28,37},{8},{14,19},{11,17,23,31,41,43,44},{21,26,29,33},{5,11,33,41},{4,5,8,9,24,44} };
        S = 37;
        T = 28;
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        System.out.println("Expected: 1");
        System.out.println(sol.numBusesToDestination(routes3, S, T));
        System.out.println();
        System.out.println();
        int[][] routes4 = { {0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29} };

        S = 4;
        T = 21;
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        System.out.println("Expected: 2");
        System.out.println(sol.numBusesToDestination(routes4, S, T));
        System.out.println();
        System.out.println();


        S = 15;
        T = 12;
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        int[][] routes5 = { {7,12},{4,5,15},{6},{15,19},{9,12,13} };
        System.out.println(sol.numBusesToDestination(routes5, S, T));
        System.out.println();
        System.out.println();
    }
}

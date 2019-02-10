import java.util.Arrays;
public class Driver{
    public static void main(String[] args) {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
     //   int price[] = {100, 180, 260, 310, 40, 535, 695};
     //   int n = price.length;


        int[][] prices = { {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 7, 3, 0, 9, 4, 8, 2, 3}, {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {9, 8, 7, 6, 5, 12, 3, 2, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1} };
        int n = 10;
        for(int i = 0; i < prices.length; i++){
            System.out.println("n = " + n);
            System.out.println(Arrays.toString(prices[i]));
            //System.out.println(prices[i]);
            //System.out.println("Expected: 3");
            //sol.stockBuySell(prices[i], prices[i].length);
            // function call
            stock.stockBuySell(prices[i], prices[i].length);
        }
    }
}

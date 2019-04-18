public class Solution{

  public static void main(String[] args) {
    int[] prices;
    prices = new int[]{3, 4, 5, 2, 7, 6, 7, 9, 12, 4, 6};
    System.out.println("Expected: 15");
    int result = 0;
    result = findMaxProfit(prices);
    System.out.println(result);
    prices = new int[]{4, 3, 2, 5, 3, 2, 7, 6, 7, 9, 12, 4, 6};
    result = findMaxProfit(prices);
    System.out.println(result);
    prices = new int[]{9, 8, 7, 6, 5, 4};
    result = findMaxProfit(prices);
    System.out.println(result);

  }
  public static int findMaxProfit(int[] prices){
    boolean sell = false;
    boolean buy = true;
    int buyPrice = 0;
    int profit = 0;
    for(int i = 0; i < prices.length-1; i++){
      if(sell && prices[i] > prices[i+1]){
        buy = true;
        sell = false;
        profit += prices[i] - buyPrice;
        buyPrice = 0;
      }
      if(buy && prices[i] < prices[i+1]){
        buyPrice = prices[i];
        sell = true;
        buy = false;
      }

    }

    if(sell && prices[prices.length-1] > buyPrice){
      profit += prices[prices.length-1] - buyPrice;
    }

    return profit;
  }

  // Runtime complexity: O(n)

}

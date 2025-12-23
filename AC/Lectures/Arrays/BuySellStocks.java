public class BuySellStocks {

    /*
     * You are given an array prices where prices[i] is the price of a given stock
     * on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you
     * cannot achieve any profit, return 0.
     */

    public static int maxProfit(int arr[]) {
        if(arr.length < 2){
            return 0;
        }
        int maxProfit = 0;
        int buyPrice = arr[0];
        int sellingPrice;
        for (int i = 0; i < arr.length; i++) {
            buyPrice = Math.min(arr[i], buyPrice);
            sellingPrice = arr[i];
            int profit = sellingPrice - buyPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };// Expected profit: 5
        System.out.println("Maximum Price: " + maxProfit(prices));

        System.out.println("Different Cases:");
        // Case 1: Normal case with profit
        int prices_case1[] = { 7, 1, 5, 3, 6, 4 }; // Expected profit: 5 (buy at 1, sell at 6)
        System.out.println("Maximum Profit Case 1: "+maxProfit(prices_case1));

        // Case 2: No profit possible (prices decline)
        int prices_case2[] = { 7, 6, 4, 3, 1 }; // Expected profit: 0
        System.out.println("Maximum Profit Case 2: "+maxProfit(prices_case2));

        // Case 3: Prices are constant
        int prices_case3[] = { 5, 5, 5, 5 }; // Expected profit: 0
        System.out.println("Maximum Profit Case 3: "+maxProfit(prices_case3));

        // Case 4: Increasing prices
        int prices_case4[] = { 1, 2, 3, 4, 5 }; // Expected profit: 4 (buy at 1, sell at 5)
        System.out.println("Maximum Profit Case 4: "+maxProfit(prices_case4));

        // Case 5: Prices have multiple local minima and maxima
        int prices_case5[] = { 3, 2, 6, 5, 0, 3 }; // Expected profit: 4 (buy at 2, sell at 6)
        System.out.println("Maximum Profit Case 5: "+maxProfit(prices_case5));

        // Case 6: Single day (no transaction possible)
        int prices_case6[] = { 10 }; // Expected profit: 0
        System.out.println("Maximum Profit Case 6: "+maxProfit(prices_case6));
    }
}

public class KnapSack01 {

    // 0-1 Knapsack Problem (Simple Recursion)
    public static int knapsack(int val[], int weight[], int W, int i) {
        if (W == 0 || i == 0) {
            return 0;
        }

        if (weight[i - 1] <= W) {
            int ans1 = val[i - 1] + knapsack(val, weight, W - weight[i - 1], i - 1); // include
            int ans2 = knapsack(val, weight, W, i - 1); // exclude
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, weight, W, i - 1);
        }
    }

    // 0-1 Knapsack (Memoization)
    public static int knapSackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + knapSackMemo(val, wt, W - wt[n - 1], n - 1, dp); // include
            int ans2 = knapSackMemo(val, wt, W, n - 1, dp); // exclude
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {// not include
            dp[n][W] = knapSackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static int KnapsackTabulation(int val[], int wt[], int W) {
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 0; i < dp.length; i++) { //0th Column
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) { //0th Row
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int value = val[i-1];
                int weight = wt[i-1];
                if(weight<=j){ //Valid
                    int ans1 = value+dp[i-1][j-weight]; //Include
                    int ans2 = dp[i-1][j]; //Exclude
                    dp[i][j] = Math.max(ans1, ans2);
                }else{ // Invalid
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }
        printDP(dp); 
        return dp[val.length][W];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    //Unbounded Knapsack
    public static int unboundedKnapsack(int val[], int wt[], int W){
        int dp[][] = new int[val.length + 1][W + 1];

        for (int i = 0; i < dp.length; i++) { //0th Column
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) { //0th Row
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int value = val[i-1];
                int weight = wt[i-1];
                if(weight<=j){ //Valid
                    int ans1 = value+dp[i][j-weight]; //Include
                    int ans2 = dp[i-1][j]; //Exclude
                    dp[i][j] = Math.max(ans1, ans2);
                }else{ // Invalid
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }
        printDP(dp); 
        return dp[val.length][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println("0-1 Knapsack without Memoization");
        System.out.println("Maximum Profit: " + knapsack(val, weight, W, val.length));

        System.out.println("---------------------------");

        System.out.println("0-1 Knapsack with Memoization");
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Maximum Profit: " + knapSackMemo(val, weight, W, val.length, dp));

        System.out.println("---------------------------");

        System.out.println("0-1 Knapsack with Tabulation");
        System.out.println("Maximum Profit: " + KnapsackTabulation(val, weight, W));

        System.out.println("---------------------------");
        System.out.println("Unbounded Knapsack");
        System.out.println("Maximum Profit: " + unboundedKnapsack(val, weight, W));
        
    }
}

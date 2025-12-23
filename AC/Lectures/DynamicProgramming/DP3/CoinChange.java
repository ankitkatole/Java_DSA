/*
 * Coin CHange Problem 
 * coins[] = 1,2,3
 * sum = 4
 * Ways= {1,1,1,1}, {1,1,2}, {2,2}, {1,3}
 * Total ways = 4
 * 
 * coins[] = 2,5,3,6
 * sum = 10
 * Ways = {2,2,2,2,2}, {2,2,3,3}, {2,3,5}, {5,5}, {4,6}
 * Total ways = 5
 */
public class CoinChange {
    public static int countWays(int coins[], int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][sum];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("# Coin Change Problem # ");
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println("Total Ways = " + countWays(coins, coins.length, sum));
    }
}

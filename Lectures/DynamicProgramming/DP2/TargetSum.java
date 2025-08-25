public class TargetSum {

    public static boolean targetSum(int num[], int target){
        int n = num.length;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i = 0; i<dp.length;i++){
            dp[i][0] = true;
        }
        for(int j = 1; j<dp[0].length;j++){
            dp[0][j] = false;
        }
        for(int i = 1; i<dp.length;i++){
            for(int j = 1; j< dp[1].length;j++){
                int value = num[i-1];
                if(value <=j){
                    dp[i][j] = dp[i-1][j-value] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][target];
    }

    public static void printDP(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numbers[] = {4,2,7,1,3};
        int target = 10;
        System.out.println(targetSum(numbers, target));
    }
}

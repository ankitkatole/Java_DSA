import java.util.*;

public class DynamicProgramming1 {

    public static int fibb(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibb(n-1)+fibb(n-2);
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibbMemo(int n){
        if(n==0 ||n == 1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = fibbMemo(n-1) + fibbMemo(n-2);
        memo.put(n, result);
        return result;
    }

    public static int fibTab(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int[] dp =  new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //Climbing Stairs: 
    // Count Ways to reach the nth stair. The person can climb either 1 stair or 2 stair ata time.
    public static int climbingStairs(int n){
        if(n==0 || n == 1){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbingStairs(n-1) + climbingStairs(n-2);
    }

    static  Map<Integer, Integer> climbingStairMemo = new HashMap<>();
    public static int climbingStairMemo(int n){
        if(n==0 || n == 1){
            return 1;
        }
        if(climbingStairMemo.containsKey(n)){
            return climbingStairMemo.get(n);
        }
        int result = climbingStairMemo(n-1) + climbingStairMemo(n-2);
        climbingStairMemo.put(n, result);
        return result;
    }

    //If variation is there that 3 stairs can be climbed at a time too then the ways[n] = ways[n-1] + ways[n-2] + ways[n-3] so on for other variations;

    //Climbing Stairs with Tabulation
    public static int climbingStairsTab(int n){
        if(n == 0  || n==1){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    

    public static void main(String[] args) {

        //Fibonacci with and without Memoization
        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i<45;i++){
            System.out.print(fibbMemo(i) + " ");
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken by fibbMemo loop: " + (endTime2 - startTime2) + " ms");
        // long startTime1 = System.currentTimeMillis();
        // for(int i = 0; i<45;i++){
        //     System.out.print(fibb(i) + " ");
        // }
        // long endTime1 = System.currentTimeMillis();
        // System.out.println();
        // System.out.println("Time taken by fibb loop: " + (endTime1 - startTime1) + " ms");
        System.out.println("-------------------------");
        // Fibonacci with Tabulation
        System.out.println("Fibonacci with Tabulation:");
        long startTime3 = System.currentTimeMillis();
        for(int i = 0; i<45;i++){
            System.out.print(fibTab(i) + " ");
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken by fibTab loop: " + (endTime3 - startTime3) + " ms");

        //Climbing Stairs
        System.out.println("-------------------------");
        System.out.println(climbingStairs(4));
        System.out.println(climbingStairMemo(4));
        System.out.println(climbingStairsTab(4));
        System.out.println("-------------------------");

    }
}
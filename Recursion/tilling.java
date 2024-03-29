import java.util.HashMap;

public class tilling {
    private static HashMap<Integer,Integer> memo = new HashMap<>();


    public static int optimizedTillingProblem(int n){
        // Base Case
        if(n==0 || n==1){
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        // Vertical Choice 
        int way1 = tillingProblem(n-1);

        // Horinzontal Choice
        int way2 = tillingProblem(n-2);

        int totalWays = way1 + way2;
        memo.put(n, totalWays);
        return totalWays;
    }

    public static int tillingProblem(int n){
        // Base Case
        if(n==0 || n==1){
            return 1;
        }
        
        // Vertical Choice 
        int way1 = tillingProblem(n-1);

        // Horinzontal Choice
        int way2 = tillingProblem(n-2);

        int totalWays = way1 + way2;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(tillingProblem(5));
        System.out.println(optimizedTillingProblem(5));
    }
}

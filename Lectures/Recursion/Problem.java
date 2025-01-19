/* Problem 1: (TILING PROBLEM) Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles.
A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.  */


/*
 * Problem 2: (PAIRING PROBLEM) Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up. 
 */

 /*
  * Problem 3: Binary Strings of Size N without consecutive 1's
  */
import java.util.HashMap;

public class Problem {

    private static HashMap<Integer,Integer> tile = new HashMap<>();
    public static int optimizedTillingProblem(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(tile.containsKey(n)){
            return tile.get(n);
        }
        int way1 = tillingProblem(n-1);
        int way2 = tillingProblem(n-2);

        int totalWays = way1 + way2;
        tile.put(n, totalWays);
        return totalWays;
    }
    public static int tillingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int way1 = tillingProblem(n - 1);
        int way2 = tillingProblem(n - 2);

        int totalWays = way1 + way2;
        return totalWays;
    }

    private static HashMap<Integer,Integer> pairs = new HashMap<>();
    public static int pairingFriends(int n){
        if(n==1 || n==2){
            return n;
        }
        if(pairs.containsKey(n)){
            return pairs.get(n);
        }
        int ways = pairingFriends(n-1)+(n-1)*pairingFriends(n-2);
        pairs.put(n,ways);
        return ways;

    }

    public static void printBinStrings(int n, int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinStrings(n-1,0,str+"0");
        if(lastPlace==0){
            printBinStrings(n-1,1,str+"1");
        }
    }

    public static void main(String[] args) {
        // System.out.println(tillingProblem(5));
        // System.out.println(optimizedTillingProblem(5));
        // System.out.println(pairingFriends(4));
        // printBinStrings(3,0,"");
    }
}

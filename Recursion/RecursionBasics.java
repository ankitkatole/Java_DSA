import java.util.HashMap;

public class RecursionBasics {

    public static void printNumDec(int n) {
        System.out.println(n);
        if (n == 1) {
            return;
        }
        printNumDec(n - 1);
    }
    public static void printNumInc(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }else{
            printNumInc(n-1);
            System.out.println(n);
        }
    }

    public static int Factorial(int n) {
        if(n==1 || n==0){
            return 1;
        }
        return n*Factorial(n-1);
    }

    private static HashMap<Integer,Integer> memo = new HashMap<>();

     public static int fibbanocci(int n){
        if(n == 1 || n == 0){
           return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int res = fibbanocci(n-1) + fibbanocci(n-2);
        memo.put(n, res);
        return res;
    }
    

    public static void main(String[] args) {
        
    }
}
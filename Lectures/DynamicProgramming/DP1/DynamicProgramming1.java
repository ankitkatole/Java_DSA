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
    public static void main(String[] args) {
        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i<45;i++){
            System.out.print(fibbMemo(i) + " ");
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken by fibbMemo loop: " + (endTime2 - startTime2) + " ms");
        long startTime1 = System.currentTimeMillis();
        for(int i = 0; i<45;i++){
            System.out.print(fibb(i) + " ");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken by fibb loop: " + (endTime1 - startTime1) + " ms");


    }
}
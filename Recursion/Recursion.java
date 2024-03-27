import java.util.*;

public class Recursion {
    static public int factorial(int n){
        int fact = n;
        if(n==0){
            return 1;
        }
        return fact*factorial(n-1);
    }
    static public int sum(int n){
        int sum = n;
        if(n == 1){
            return 1;
        }
        sum += sum(n-1);
        return sum;
    }
    static public void print(int n){
        if(n==1){
            System.out.println(n);
            return;}
        print(n-1);
        System.out.println(n);
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

    public static Boolean isSorted(int arr[],int i){
        if(i >= arr.length-1)//Base Case: Sorted array
         return true;
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[],int key,int i){
        if(i >= arr.length)
            return -1;
        if(arr[i] != key){
            return firstOccurence(arr, key, i+1);
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,3,4,5,6};
        System.out.println(firstOccurence(arr, 3, 0));
        
    }
}


public class Practice {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        reverseArray1(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        int n = 5;
        System.out.println(n+"th Fibonacci Number is "+fibonacci(n));
        System.out.println(countGoodNumbers(50));
    }

    
    //Reversing an array Using Recusrsion
    public static void reverseArray1(int arr[], int i, int j){
        if(i>=j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverseArray1(arr,i+1,j-1);
    }

    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    static final int MOD = 1000000007;
    public static int count(long n, long i){
        if(i==n) return 1;
        int res = 0;
        if(i%2 == 0){
            for(int j = 0; j<5; j++){
                res = (res + count(n,i+1))%MOD;
            }
        }else{
            for(int j = 0;j<4;j++){
                res = (res+count(n,i+1))%MOD;
            }
        }
        return res;
    }
    public static int countGoodNumbers(long n) {
        return count(n,0);
    }
}

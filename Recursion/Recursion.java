

public class Recursion {
    static public int factorial(int n){
        int fact = n;
        if(n<=1){
            return 1;
        }
        return fact*factorial(n-1);
    }

    static public void print(int n){
        if(n==1){
            System.out.println(n);
            return;}
        print(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        // System.out.println(factorial(-1));
        print(10);
    }
}

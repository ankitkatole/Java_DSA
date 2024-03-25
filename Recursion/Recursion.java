

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
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}

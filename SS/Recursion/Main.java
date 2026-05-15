package Recursion;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        printNTimes(0,n);
        System.out.println();
        print1ToN(n, n);
        System.out.println();
        printNTo1(1,n);
        System.out.println();
        System.out.println("Sum of "+n+" numbers: "+sumOfNNumber(n));
    }

    private static void printNTimes(int i,int n) {
        if(i == n) return;
        System.out.print("Dev ");
        printNTimes(i+1, n);
    }

    public static void print1ToN(int i,int n){
        if(i<1) {
            return;
        }
        print1ToN(i-1,n);
        System.out.print(i+" ");
    }
    public static void printNTo1(int i, int n){
        if(i > n) return;
        printNTo1(i+1, n);
        System.out.print(i+" ");
    }
    public static int sumOfNNumber(int n){
        if(n == 1 || n == 0){
            return n;
        }
        return n+sumOfNNumber(n-1);
    }
}

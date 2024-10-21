import java.util.HashMap;
import java.util.HashSet;

public class RecursionBasics {

    public static void printNumDec(int n) {
        System.out.println(n);
        if (n == 1) {
            return;
        }
        printNumDec(n - 1);
    }

    public static void printNumInc(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        } else {
            printNumInc(n - 1);
            System.out.println(n);
        }
    }

    public static int Factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    private static HashMap<Integer, Integer> fib = new HashMap<>();

    public static int fibbanocci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (fib.containsKey(n)) {
            return fib.get(n);
        }

        int res = fibbanocci(n - 1) + fibbanocci(n - 2);
        fib.put(n, res);
        return res;
    }

    public static Boolean isSorted(int arr[], int i) {
        if (i >= arr.length - 1)// Base Case: Sorted array
            return true;
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length || i < 0)
            return -1;
        if (arr[i] != key) {
            return firstOccurence(arr, key, i + 1);
        }
        return i;
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length || i < 0)
            return -1;
        if (arr[i] != key) {
            return lastOccurence(arr, key, i - 1);
        }
        return i;
    }

    public static int binarySearch(int arr[], int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearch(arr, key, low, mid - 1);
        } else {
            return binarySearch(arr, key, mid + 1, high);
        }
    }

    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        return x * power(x, n - 1);
    }

    public static int optimizedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(x, n / 2);
        halfPower *= halfPower;
        if (n % 2 != 0) {
            return x * halfPower;
        }
        return halfPower;
    }

    public static void removeDuplicates(String str, int i, StringBuilder sb, boolean track[]) {
        if (str.length() == 0 || str.length() == 1) {
            System.out.println(sb);
            return;
        }
        if (i == str.length()) {
            System.out.println(sb);
            return;
        }
        char curChar = str.charAt(i);
        if (track[curChar - 'a'] == true) {
            removeDuplicates(str, i + 1, sb, track);
        } else {
            track[curChar - 'a'] = true;
            removeDuplicates(str, i + 1, sb.append(curChar), track);
        }

    }

    private static HashSet<Character> charSet = new HashSet<>();
    public static void removeDuplicatesOptimized(String str, int i, StringBuilder sb) {
        if (str.length() == 0 || str.length() == 1) {
            System.out.println(sb);
            return;
        }
        if (i == str.length()) {
            System.out.println(sb);
            return;
        }
        char curChar = str.charAt(i);
        if (charSet.contains(curChar)) {
            removeDuplicatesOptimized(str, i + 1, sb);
        } else {
            charSet.add(curChar);
            removeDuplicatesOptimized(str, i + 1, sb.append(curChar));
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(lastOccurence(arr, 1, arr.length - 1));
        // System.out.println(firstOccurence(arr, 1, 0));
        // System.out.println(power(2, 5));
        // System.out.println(optimizedPower(2, 5));
        String str = "aaabbaacccdd";
        // removeDuplicates(str, 0, new StringBuilder(""),new boolean[26]);
        // removeDuplicatesOptimized(str, 0, new StringBuilder(""));

    }
}
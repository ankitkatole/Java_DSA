import java.util.*;

public class Assignmenet {

    /*
     * Question 1 : For a given integer array of size N. You have to find all the
     * occurrences
     * (indices) of a given element (Key) and print them. Use a recursive function
     * to solve this
     * problem.
     * Sample Input : arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
     * Sample Output : 1 5 7 8
     */

    static HashSet<Integer> list = new HashSet<>();

    public static void allOccurences(int arr[], int key, int n) {
        if (n < 0) {
            System.out.println(list);
            return;
        }
        if (arr[n] == key) {
            list.add(n);
        }
        allOccurences(arr, key, n - 1);
    }

    /*
     * Question 2 :
     * You are given a number (eg - 2019), convert it into a String of english like
     * “two zero one nine”. Use a recursive function to solve this problem.
     * NOTE - The digits of the number will only be in the range 0-9 and the last
     * digit of a numbercan’t be 0.
     * Sample Input : 1947
     * Sample Output : “one nine four seven”
     */
    static String num[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static String printNumber(String n, String s) {
        if (n.length() == 0) {
            return s;
        }
        return printNumber(n.substring(0, n.length() - 1), num[(int) n.charAt(n.length() - 1) - 48] + " " + s);
    }

    /*
     * Question 3 : Write a program to find Length of a String using Recursion.
     */
    public static int strLength(String str, int len) {
        if (str == "") {
            return len;
        }
        return strLength(str.substring(1), len + 1);
    }

    /*
     * Question 4 : We are given a string S, we need to find the count of all contiguous substrings starting and ending with the same character.
     * Sample Input 1 : S = "abcab"
     * Sample Output 1 : 7
     * There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca,
     * bcab, c, ca, cab, a, ab, b
     * Out of the above substrings, there are 7 substrings : a, abca, b, bcab, c, a
     * and b. So, only 7
     * contiguous substrings start and end with the same character.
     * Sample Input 2 : S = "aba"
     * Sample Output 2 : 4
     * The substrings are a, b, a and aba.
     */

     public static int palendromeSubstring(String str, int count){
         if(str.length() == 0){
            return count;}
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(0)==str.charAt(i)){
                    count++;
                }
            }
            return palendromeSubstring(str.substring(1), count);
     }


     

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        int n = arr.length;
        allOccurences(arr, key, n - 1);

        int input = 2019;
        String num = Integer.toString(input);
        String res = "";
        System.out.println(printNumber(num, res));

        System.out.println(strLength("abcdefghijklmnopqrstuvwxyz", 0));

        System.out.println(palendromeSubstring("aba", 0));

    }
}

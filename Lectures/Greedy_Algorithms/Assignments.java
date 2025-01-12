public class Assignments {

    // Question 1 :
    // Maximum Balanced String Partitions
    // We have balanced string str of size N with an equal number of L and R, the
    // task is to find a
    // maximum number X, such that a given string can be partitioned into X balanced
    // substring. A
    // string is called to be balanced if the number of ‘L’s in the string equals
    // the number of ‘R’s.
    // Input : “LRRRRLLRLLRL”
    // Output : 3

    public static int maxBalancedStringPartitions(String str) {
        int partition = 0, balance = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'L')
                balance++;
            else
                balance--;
            if (balance == 0)
                partition++;
        }
        return partition;
    }

    // Question 2 :
    // Kth largest odd number in a given range
    // We have two variables L and R, indicating a range of integers from L to R
    // inclusive, and a
    // number K, the task is to find Kth largest odd number. If K > number of odd
    // numbers in the range
    // L to R then return 0.
    // Sample Input 1 : L = -3, R = 3, K = 1
    // Sample Output 1 : 3
    public static int kthLargestOddNumber(int L, int R, int K) {
        for (int i = R; i >= L; i--) {
            if (i % 2 != 0) {
                K--;
                if (K == 0)
                    return i;
            }
        }
        return 0;
    }

    // Question 3 :
    // Lexicographically smallest string of length N and sum K
    // We have two integers N and K. The task is to print the lexicographically
    // smallest string of
    // length N consisting of lower-case English alphabets such that the sum of the
    // characters of
    // the string equals to K where ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, ….. and ‘z’ = 26.
    // Sample Input 1 : N = 5, K = 42
    // Sample Output 1 : aaamz
    // Sample Input 2 : N = 3, K = 25
    // Sample Output 2 : aaw

    public static String lexicographicallySmallestString(int N, int K) {
        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }
        int remainingSum = K - N;
        int index = N - 1;
        while (remainingSum > 0 && index >= 0) {
            int addValue = Math.min(25, remainingSum);
            result[index] += addValue;
            remainingSum -= addValue;
            index--;
        }
        return new String(result);
    }

//Question 4 :
// Best Time to Buy and Sell Stock
// Given an array prices[] of length N, representing the prices of the stocks on different days, the
// task is to nd the maximum prot possible for buying and selling the stocks on different days
// using transactions where at most one transaction is allowed.
// Note: Stock must be bought before being sold.
// Sample Input 1 : prices[] = {7, 6, 4, 3, 1}
// Sample Output 1 : 0
// Sample Input 2 : prices[] = {7, 1, 5, 3, 6, 4]
// Sample Output 2 : 5
    public static int bestTimeToBuyAndSellStock(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int i = 0;i<prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            int todayProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, todayProfit);
        }
        return maxProfit;
    }

// Question 5 :
// Split the given array into K sub-arrays
// We have an Array[] of N elements and a number K. ( 1 <= K <= N ) . Split the given array into K
// subarrays (they must cover all the elements). The maximum subarray sum achievable out of K
// subarrays formed must be the minimum possible. Find that possible subarray sum.
// Sample Input 1 :Array[] = {1, 1, 2} K = 2
// Sample Output 1 : 2
// Sample Input 2 : Array[] = {1, 2, 3, 4}, K = 3
// Sample Output 2 : 4
    

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalancedStringPartitions(str));

        int L = -3, R = 3, K = 1;
        System.out.println("The " + K + "th largest odd number in the range " + L + " to " + R + " is "+ kthLargestOddNumber(L, R, K));
        
        int N = 5, Ki = 42;
        System.out.println("The lexicographically smallest string of length " + N + " and sum " + Ki + " is " + lexicographicallySmallestString(N, Ki));
        
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("The maximum profit possible is " + bestTimeToBuyAndSellStock(prices));
    }
}

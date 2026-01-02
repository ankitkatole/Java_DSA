/*Leetcode 75
Problem: Sort Colors (Dutch National Flag Problem)
You are given an array nums of length n, where each element represents a color:
0 represents red
1 represents white
2 represents blue

Your task is to sort the array in-place so that all objects of the same color are grouped together and arranged in the following order:
red (0), then white (1), then blue (2).

⚠️ You are not allowed to use the built-in sorting function.
Input

An integer array nums of length n
Each element in nums is either 0, 1, or 2
Output
The same array sorted in-place in the order 0 → 1 → 2

Examples
Example 1
Input:  [2, 0, 2, 1, 1, 0]
Output: [0, 0, 1, 1, 2, 2]

Example 2
Input:  [2, 0, 1]
Output: [0, 1, 2]

Constraints
1 ≤ n ≤ 300
nums[i] ∈ {0, 1, 2}

*/

import java.util.*;

public class DutchNationalFlagAlgo {

    /*
        We use three pointers: low, mid, and high to divide the array into sections.
        0 → low-1 contains 0s
        low → mid-1 contains 1s
        high+1 → end contains 2s
        mid → high is the unsorted part
        While mid <= high:
        If nums[mid] == 0: swap with low, increment both low and mid
        If nums[mid] == 1: increment mid
        If nums[mid] == 2: swap with high, decrement high (do not move mid)
        This sorts the array in one pass using constant extra space.
    */
    public static void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }

        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { 
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    /*
        BruteForce Approach:
        We are given an array containing only 0s, 1s, and 2s. Since the values are fixed and known, the simplest approach is to first count how many 0s, 1s, and 2s are present in the array. After counting, we overwrite the original array based on the frequency of these values first fill it with 0s, then 1s, then 2s. This does not require any extra array and modifies the input array in-place.
        Initialize three counters to count the frequency of 0s, 1s, and 2s
        Loop through the array once and count each number
        In the second loop, fill the array based on the frequency of each number: first 0s, then 1s, then 2s
    */
   public static void sortColorsBruteForce(int[] nums){
        int n = nums.length;
        if(n == 0 || n == 1){
            return;
        }
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                count0++;
            } else if(nums[i] == 1){
                count1++;
            } else {
                count2++;
            }
        }
        int index = 0;
        for(int i = 0; i < count0; i++){
            nums[index++] = 0;
        }
        for(int i = 0; i < count1; i++){
            nums[index++] = 1;
        }
        for(int i = 0; i < count2; i++){
            nums[index++] = 2;
        }
   }

    public static void main(String[] args) {

        int[][] testCases = {
            {2, 0, 2, 1, 1, 0},
            {2, 0, 1},
            {0},
            {1},
            {2, 2, 1, 1, 0, 0},
            {}
        };

        System.out.println("Using Dutch National Flag Algorithm:");
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + " Before: " 
                               + Arrays.toString(testCases[i]));

            sortColors(testCases[i]); // static method call

            System.out.println("Test Case " + (i + 1) + " After : " 
                               + Arrays.toString(testCases[i]));
            System.out.println();
        }
        testCases = new int[][] {
            {2, 0, 2, 1, 1, 0},
            {2, 0, 1},
            {0},
            {1},
            {2, 2, 1, 1, 0, 0},
            {}
        };
        System.out.println("-----------------------------------");
        System.out.println("Using Brute Force Approach:");
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + " Before: " 
                               + Arrays.toString(testCases[i]));

            sortColorsBruteForce(testCases[i]); // static method call

            System.out.println("Test Case " + (i + 1) + " After : " 
                               + Arrays.toString(testCases[i]));
            System.out.println();
        }
    }
}

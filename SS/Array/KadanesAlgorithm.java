/* 
Kadane's Algorithm : Maximum Subarray Sum in an Array

13

Problem Statement: Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.

A subarray is a contiguous non-empty sequence of elements within an array.

Examples
Example 1:
Input:
 nums = [2, 3, 5, -2, 7, -4]  
Output:
 15  
Explanation:
 The subarray from index 0 to index 4 has the largest sum = 15, which is the maximum sum of any contiguous subarray.

Example 2:
Input:
 nums = [-2, -3, -7, -2, -10, -4]  
Output:
 -2  
Explanation:
 The largest sum is -2, which comes from taking the element at index 0 or index 3 as the subarray. Since all numbers are negative, the subarray with the least negative number gives the largest sum.
 */

import java.util.*;

public class KadanesAlgorithm {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case with positive and negative numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1: " + maxSubArray(nums1));  // Expected output: 6

        // Test Case 2: Array with all positive numbers
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + maxSubArray(nums2));  // Expected output: 15

        // Test Case 3: Array with all negative numbers
        int[] nums3 = {-1, -2, -3, -4};
        System.out.println("Test Case 3: " + maxSubArray(nums3));  // Expected output: -1

        // Test Case 4: Single element array (positive)
        int[] nums4 = {3};
        System.out.println("Test Case 4: " + maxSubArray(nums4));  // Expected output: 3

        // Test Case 5: Single element array (negative)
        int[] nums5 = {-3};
        System.out.println("Test Case 5: " + maxSubArray(nums5));  // Expected output: -3

        // Test Case 6: Empty array
        int[] nums6 = {};
        System.out.println("Test Case 6: " + maxSubArray(nums6));  // Expected output: 0

        // Test Case 7: Array with zero values
        int[] nums7 = {0, 0, 0, 0, 0};
        System.out.println("Test Case 7: " + maxSubArray(nums7));  // Expected output: 0

        // Test Case 8: Array with both large positive and negative numbers
        int[] nums8 = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("Test Case 8: " + maxSubArray(nums8));  // Expected output: 18 (subarray [3, 10, -4, 7, 2])
    }


}
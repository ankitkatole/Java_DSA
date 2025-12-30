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
/*Brute Force
Algorithm
Iterate through the array with variable i, which represents the starting index of each subarray. The possible values for i range from 0 to n-1, where n is the size of the array.
Inside the first loop, run another loop with variable j that represents the ending index of the subarray. For each i, j can range from i to n-1.
For each subarray defined by i and j, iterate through its elements to calculate the sum. Maintain a variable, max, to store the maximum sum encountered so far during the iteration.
At each step, compare the current subarray sum with the current max value. If the current sum is greater, update the max value with the new sum.
Finally, after completing all iterations, return the max variable, which holds the maximum sum of any subarray.
*/


}
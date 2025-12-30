
/*
next_permutation : find next lexicographically greater permutation
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).

Examples
Input: Arr[] = {1,3,2}
Output: {2,1,3}
Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
Input : Arr[] = {3,2,1}
Output: {1,2,3}
Explanation : As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the lowest permutation.
*/

import java.util.*;

public class NextPermutation {

    // Function to find the next permutation (Brute Force)
    public static List<Integer> nextPermutationBruteForce(int[] nums) {
        int[] original = nums.clone(); // store original

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<List<Integer>> all = new ArrayList<>();
        permute(sorted, 0, all);

        List<Integer> target = new ArrayList<>();
        for (int n : original)
            target.add(n);

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(target)) {
                if (i == all.size() - 1)
                    return all.get(0);
                return all.get(i + 1);
            }
        }

        return target;
    }

    // Backtracking permutation generator
    private static void permute(int[] nums, int start, List<List<Integer>> all) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            all.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, all);
            swap(nums, i, start);
        }
    }

    // Swap helper
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] nextPermutationOptimal(int[] arr){
        if(arr.length <= 1) return arr;
        int breakPoint = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1){
            reverse(arr, 0, arr.length - 1);
            return arr;
        }
        int firstGreater = -1;
        for(int i = arr.length - 1; i > breakPoint; i--){
            if(arr[i] > arr[breakPoint]){
                firstGreater = i;
                break;
            }
        }
        swap(arr, breakPoint, firstGreater);
        reverse(arr, breakPoint + 1, arr.length - 1);
        return arr;
    }

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = { 1, 3,2 };
        List<Integer> result = nextPermutationBruteForce(nums);
        for (int x : result)
            System.out.print(x + " ");
        System.out.println();

        int[] nums2 = {1,2,3,4};
        int[] result2 = nextPermutationOptimal(nums2);  
        for (int x : result2)
            System.out.print(x + " ");
    }
}

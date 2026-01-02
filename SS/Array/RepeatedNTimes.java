import java.util.*;

public class RepeatedNTimes {

    /*
     * LeetCode 961: N-Repeated Element in Size 2N Array
     * 
     * Problem summary:
     * - Array size is 2 * n
     * - There are n + 1 unique elements
     * - One element appears exactly n times
     * - All others appear once
     * - We need to return the element repeated n times
     */

    // Brute force approach using HashMap
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int repeatedNTimesBrute(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == n) {
                return key;
            }
        }

        return -1;
    }

    // Optimized approach using HashSet
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int repeatedNTimesOptimized(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] test1 = { 1, 2, 3, 3 };
        int[] test2 = { 2, 1, 2, 5, 3, 2 };
        int[] test3 = { 5, 1, 5, 2, 5, 3, 5, 4 };

        System.out.println("Brute Force Results:");
        System.out.println(repeatedNTimesBrute(test1)); // 3
        System.out.println(repeatedNTimesBrute(test2)); // 2
        System.out.println(repeatedNTimesBrute(test3)); // 5

        System.out.println();

        System.out.println("Optimized Results:");
        System.out.println(repeatedNTimesOptimized(test1)); // 3
        System.out.println(repeatedNTimesOptimized(test2)); // 2
        System.out.println(repeatedNTimesOptimized(test3)); // 5
    }
}

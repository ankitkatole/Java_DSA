
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trp after Raining.
import java.util.*;

public class TrappedRainWater {
    public static int trappedRainwater(int arr[]) {
        int n = arr.length;
        if (n <= 2) {
            return 0;
        }
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < arr.length; i++) {
            int water_level = Math.min(rightMax[i], leftMax[i]);
            trappedWater += water_level - arr[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("Total Trapped Water: " + trappedRainwater(height));

        System.out.println("Different Cases:");
        // Case 1: Best case (no bars)
        int height_case1[] = {}; // Expected water trapped: 0
        System.out.println("Total Trapped Water Case 1: " + trappedRainwater(height_case1));

        // Case 2: Best case (flat surface)
        int height_case2[] = { 1, 1, 1, 1 }; // Expected water trapped: 0
        System.out.println("Total Trapped Water Case 2: " + trappedRainwater(height_case2));

        // Case 3: Worst case (decreasing heights)
        int height_case3[] = { 5, 4, 3, 2, 1 }; // Expected water trapped: 0
        System.out.println("Total Trapped Water Case 3: " + trappedRainwater(height_case3));

        // Case 4: Worst case (complex shape with no trapped water)
        int height_case4[] = { 1, 2, 3, 4, 5 }; // Expected water trapped: 0
        System.out.println("Total Trapped Water Case 4: " + trappedRainwater(height_case4));

        // Case 5: Average case (some trapped water)
        int height_case5[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; // Expected water trapped: 6
        System.out.println("Total Trapped Water Case 5: " + trappedRainwater(height_case5));

        // Case 6: Complex case (more complex terrain)
        int height_case6[] = { 4, 2, 0, 3, 2, 5 }; // Expected water trapped: 9
        System.out.println("Total Trapped Water Case 6: " + trappedRainwater(height_case6));

    }
}

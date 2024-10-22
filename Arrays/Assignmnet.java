import java.util.HashSet;

public class Assignmnet {

    /*
     * Question 1: Given an integer array nums, return true if any value appears at
     * least twice in the
     * array, and return false if every element is distinct.
     * Example 1:
     * Input: nums = [1, 2, 3, 1]
     * Output: true
     * Example 2:
     * Input: nums = [1, 2, 3, 4]
     * Output: false
     * Example 3:
     * Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
     * Output: true
     */

    public static boolean checkDuplicates(int arr[]) {
        int n = arr.length;
        if (n <= 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    return true;
            }
        }

        return false;
    }

    /*
     * Question 2: There is an integer array nums sorted in ascending order (with
     * distinct values).
     * Prior to being passed to your function, nums is possibly rotated at an
     * unknown
     * pivot index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k],
     * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
     * example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and
     * become [4,5,6,7,0,1,2].
     * Given the array nums after the possible rotation and an integer target,
     * return the
     * index of target if it is in nums, or -1 if it is not in nums.
     * You must write an algorithm with O(log n) runtime complexity.
     * Example 1:
     * Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
     * Output: 4
     * Example 2:
     * Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 3
     * Output: -1
     * 
     * Example 3:
     * Input: nums = [1], target = 0
     * Output: -1
     */
    public static int searchTarget(int arr[], int target) {
        int minimum = searchMin(arr);
        int low = 0;
        int high = arr.length - 1;
        if (arr[minimum] <= target && target <= arr[high]) {
            return binarySearch(arr, minimum, high, target);
        } else {
            return binarySearch(arr, low, minimum, target);
        }
    }

    public static int binarySearch(int arr[], int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int searchMin(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            } else if (arr[mid] >= arr[low] && arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    /*
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
     * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
        Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
        Return k.
     */

    static HashSet<Integer> t = new HashSet<>();
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; 
        int n = nums.length;
        int arr[] = new int[n];
        int j = 0;
        for(int i = 0; i<n;i++){
            if(t.contains(nums[i])){
                continue;
            }
            arr[j++] = nums[i];
            t.add(nums[i]);
        }
        for(int i = 0;i<n;i++){
            nums[i] = arr[i];
        }
        int l = t.size();
        t.clear();
        return l;
    }

    public static int removeDuplicates2(int[] nums){
        if(nums.length == 0) return 0;
        int u = 1;
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] != nums[u-1]){
                nums[u++] = nums[i];
            }
        }
        return u;
    }
    
    public static void main(String[] args) {
        // int num[] = { 1, 2, 3, 1 };
        // System.out.println(checkDuplicates(num));
        // int num2[] = { 1, 2, 3, 4 };
        // System.out.println(checkDuplicates(num2));

        int nums3[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(searchTarget(nums3, target));
        int nums4[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(searchTarget(nums4, 3));
    }
}

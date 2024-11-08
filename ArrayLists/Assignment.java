import java.util.*;

public class Assignment {

    // Lonely Numbers in ArrayList (MEDIUM)
    // You are given an integer arraylist nums. A number x is lonely when it appears
    // only once, and
    // no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
    // Return all lonely numbers in nums. You may return the answer in any order.
    // Sample Input 1 : nums = [10,6,5,8]
    // Sample Output 1 : [10,8]
    // Sample Input 2 : nums = [1,3,5,3]
    // Sample Output 2 : [1,5]
    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!(list.contains(list.get(i) + 1) || list.contains(list.get(i) - 1))
                    && (Collections.frequency(list, list.get(i)) < 2)) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> unique = new ArrayList<>();
        for (int num : nums) {
            if (freq.get(num) == 1) {
                unique.add(num);
            }
        }
        for (int num : unique) {
            if (!freq.containsKey(num + 1) && !freq.containsKey(num - 1)) {
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Test Case 1
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(10);
        nums1.add(6);
        nums1.add(5);
        nums1.add(8);
        System.out.println("Output for " + nums1 + " is " + lonelyNumbers(nums1));

        // Test Case 2
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(3);
        nums2.add(5);
        nums2.add(3);
        System.out.println("Output for " + nums2 + " is " + lonelyNumbers(nums2));

        // Test Case 3
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(7);
        nums3.add(2);
        nums3.add(9);
        System.out.println("Output for " + nums3 + " is " + lonelyNumbers(nums3));

        // Test Case 4
        ArrayList<Integer> nums4 = new ArrayList<>();
        nums4.add(4);
        nums4.add(5);
        nums4.add(6);
        System.out.println("Output for " + nums4 + " is " + lonelyNumbers(nums4));

        // Test Case 5
        ArrayList<Integer> nums5 = new ArrayList<>();
        System.out.println("Output for " + nums5 + " is " + lonelyNumbers(nums5));

        // Test Case 6
        ArrayList<Integer> nums6 = new ArrayList<>();
        nums6.add(3);
        nums6.add(3);
        nums6.add(4);
        nums6.add(4);
        nums6.add(5);
        nums6.add(5);
        System.out.println("Output for " + nums6 + " is " + lonelyNumbers(nums6));

        // Test Case 7
        ArrayList<Integer> nums7 = new ArrayList<>();
        nums7.add(0);
        nums7.add(1000000);
        nums7.add(999999);
        System.out.println("Output for " + nums7 + " is " + lonelyNumbers(nums7));

        // Test Case 8
        ArrayList<Integer> nums8 = new ArrayList<>();
        nums8.add(2);
        nums8.add(3);
        nums8.add(10);
        nums8.add(15);
        nums8.add(16);
        nums8.add(20);
        System.out.println("Output for " + nums8 + " is " + lonelyNumbers(nums8));

        // Test Case 9
        ArrayList<Integer> nums9 = new ArrayList<>();
        nums9.add(7);
        System.out.println("Output for " + nums9 + " is " + lonelyNumbers(nums9));

        // Test Case 10
        ArrayList<Integer> nums10 = new ArrayList<>();
        nums10.add(11);
        nums10.add(13);
        nums10.add(13);
        nums10.add(17);
        nums10.add(18);
        nums10.add(20);
        System.out.println("Output for " + nums10 + " is " + lonelyNumbers(nums10));
    }
}

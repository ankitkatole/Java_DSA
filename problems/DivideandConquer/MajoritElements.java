/* 
    Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
that the majority element always exists in the array.
Sample Input 1 : nums = [3,2,3]
Sample Output 1 : 3
Sample Input 2 : nums = [2,2,1,1,1,2,2]
Sample Output 2 : 2
Constraints (extra Conditions):
● n == nums.length
● 1 <= n <= 5 * 104
● -109 <= nums[i] <= 109

 */
public class MajoritElements {
    public static int majorityElement(int arr[]){
        return majorityOccurences(arr, 0, arr.length-1);
    }

    public static int majorityOccurences(int arr[], int start, int end){
        if(start == end){
            return arr[start];
        }
        int mid = start + (end-start)/2;
        int leftMajority = majorityOccurences(arr, start, mid);
        int rightMajority = majorityOccurences(arr, mid+1, end);

        if(leftMajority == rightMajority){
            return leftMajority;
        }
        int leftCount = countMajority(arr, start, end, leftMajority);
        int rightCount = countMajority(arr, start, end, rightMajority);
        if(leftCount > ((end - start +1)/2)){
            return leftMajority;
        }
        else if(rightCount > ((end - start +1)/2)){
            return rightMajority;
        }
        else{
            return -1;
        }

    }


    public static int countMajority(int arr[], int low, int high, int target){
        int count = 0;
        for(int i = low; i <= high; i++){
            if(arr[i] == target){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println("Majority Element "+ majorityElement(nums));
    }
}

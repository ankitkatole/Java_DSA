/*
    Given sorted rotated arraywith distinct element in ascending order.
    Rotated at pivot point. Find index of Given element.
    eg:
    4 5 6 7 0 1 2
    target 0
    output 4
 */
public class SearchRotatedArray {
    public static int searchIndex(int arr[],int target, int start,int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;
        if(arr[mid] == target){
            return mid;
        }
        /*
            L1 _______      L2_______
               4 5 6 7          0 1 2
         */
        //Case 1: Mid Will Lie on Line 1
        if(arr[start] <=arr[mid]){
            //Case A: on Left of Mid: 
            if(arr[start] <= target && arr[mid] >= target){
                return searchIndex(arr, target, start, mid - 1);
            }
            //Case B: Mid lies on right of Mid
            else {
                return searchIndex(arr, target, mid+1, end);
            }
        }
        // Mid lies on Line 2
        else{
            //Case C: On Right of mid
            if(arr[end] >= target && target >= arr[mid]){
                return searchIndex(arr, target, mid+1, end);
            }
            // Case D: on left of mid
            else{
                return searchIndex(arr, target, start, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(searchIndex(arr, 0, 0, arr.length-1));
    }
}
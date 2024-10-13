//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trp after Raining.
import java.util.*;



public class TrappedRainWater {
    public static int trappedRainwater(int arr[]){
        int n = arr.length;
        if(n <= 2){
            return 0;
        }
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        leftMax[0] = arr[0];
        for(int i =1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        rightMax[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for(int i = 0; i< arr.length;i++){
            int water_level = Math.min(rightMax[i],leftMax[i]);
            trappedWater += water_level - arr[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("Total Trapped Water: "+trappedRainwater(height));
    }
}

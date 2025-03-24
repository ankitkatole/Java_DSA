import java.util.*;

public class Questions {
    /*
     * 1. Majority Element
     * Given an array of size n, find the majority element. The majority element is the element that appears more than n/3 times.
     */
    public static ArrayList<Integer> majorityElement(int arr[]){
        int n = arr.length/3;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for(int i:set){
            if(map.get(i)>=n){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("Question 1 : Majority Element");
        int arr[] = {1,3,2,5,1,3,1,3,1,3,1,5};
        System.out.println(majorityElement(arr));
    }
}

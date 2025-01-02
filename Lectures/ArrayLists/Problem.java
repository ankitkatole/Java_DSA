import java.util.*;
public class Problem {
    public static int containerWithMostWater(ArrayList<Integer> list){
        if(list.size() == 1){
            return 0;
        }         
        int l = 0, r = list.size()-1, maxWater = 0;
        while(l<=r){
            maxWater = Math.max(maxWater,Math.min(list.get(l),list.get(r))*(r-l));
            if(list.get(l) <= list.get(r)){
                l++;
            }else{
                r--;
            }
        }
        return maxWater;
    }

     public static boolean pairSum1(ArrayList<Integer> list, int target){
        if(list.size() == 0 || list.size() == 1){
            return false;
        }
        int lp = 0;
        int rp = list.size()-1;
        while(lp<rp){
            int sum = list.get(lp)+list.get(rp);
            if(sum == target){
                return true;
            }else if(sum < target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
     }

    public static boolean pairSum2(ArrayList<Integer> list,int target){
        if(list.size() == 0 || list.size() == 1){
            return false;
        }
        int n = list.size();
        int rp =0;
        for(int i = 0;i<n-1;i++){
            if(list.get(i) > list.get(i+1)){
                rp = i;
                break;
            }
        }
        int lp = rp+1;

        while(lp != rp){
            if(list.get(lp)+list.get(rp) == target){
                return true;
            }else if(list.get(lp)+list.get(rp) <= target){
                lp = (lp+1)%n;
            }else{
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Container With Most Water
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println("Maximum Water in Container = "+containerWithMostWater(height));
        //Pair Sum 1
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("Pair Sum 1: Occurence of pairs having sum as target "+ pairSum1(list, 50));

        //Pair Sum 2
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        System.out.println("Pair Sum 2: Occurence of pairs having sum as target "+ pairSum2(list2, 12));

    }
}

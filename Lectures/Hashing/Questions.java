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

    /*
     * Question 2: Valid Anagram
     *   Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     */

     public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i))==0){
                    map.remove(t.charAt(i));
                }
            }else{
                return false;
            }
        }
        return true;
     }
    public static void main(String[] args) {
        System.out.println("Question 1 : Majority Element");
        int arr[] = {1,3,2,5,1,3,1,3,1,3,1,5};
        System.out.println(majorityElement(arr));
        System.out.println("-------------------------------------------------");
        System.out.println("Question 2 : Valid Anagram");
        String s = "knee";
        String t = "keen";
        System.out.println(isAnagram(s,t));
        System.out.println("-------------------------------------------------");
    }
}

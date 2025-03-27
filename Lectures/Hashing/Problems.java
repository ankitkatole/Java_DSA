import java.util.*;
public class Problems {
    /*
     * Problem: Bottom View of Binary Tree
     */
    static class Node{
        int data;
        int hd;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.hd = 0;
        }
    }

    public static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        root.hd = 0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.hd;;
            map.put(hd,temp.data);
            if(temp.left != null){
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }

        }
        for(int i : map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }

    /*
     * Problem 2: Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */

     public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                return new int[] {map.get(difference),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1}; // return -1 if no solution found
     }
    public static void main(String[] args) {
        //Problem 1: Bottom View of Binary Tree
        System.out.println("Problem 1: Bottom View of Binary Tree");
        Node root = new Node(1, null, null);
        root.left = new Node(2, null, null);
        root.right = new Node(3, null, null);
        root.left.left = new Node(4, null, null);
        root.left.right = new Node(5, null, null);
        root.right.left = new Node(6, null, null);
        root.right.right = new Node(7, null, null);
        root.left.right.left = new Node(8, null, null);
        root.left.right.right = new Node(9, null, null);
        System.out.println("Top View: " + topView(root));
        System.out.println("----------------------");

        //Problem 2: Two Sum
        System.out.println("Problem 2: Two Sum");
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if(result[0] != -1){
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }
        System.out.println("----------------------");
    }
}


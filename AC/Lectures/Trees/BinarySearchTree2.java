import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchTree2 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node sortedArrayToBST(Node root, int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        root = new Node(arr[mid]);
        root.left = sortedArrayToBST(root.left, arr, start, mid - 1);
        root.right = sortedArrayToBST(root.right, arr, mid + 1, end);
        return root;
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void inorder(Node root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public static Node balancedBST(Node root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return sortedArrayToBST(root, arr.stream().mapToInt(i -> i).toArray(), 0, arr.size() - 1);
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class Info{
        boolean isBSt;
        int size;
        int min;
        int max;

        public Info(boolean isBSt, int size, int min, int max){
            this.isBSt = isBSt;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = 1 + leftInfo.size + rightInfo.size;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBSt && rightInfo.isBSt){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static Node mergeBST(Node b1, Node b2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(b1, arr1);
        inorder(b2, arr2);
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }
        return sortedArrayToBST(null, arr.stream().mapToInt(k -> k).toArray(), 0, arr.size() - 1);
    }

    public static void printPreOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    
    public static void main(String[] args) {
        Node root = null;
        int[] arr = {3,5,6,8,10,11,12};
        root = sortedArrayToBST(root, arr, 0, arr.length - 1);
        printInOrder(root);
        System.out.println("Height of above tree is: " + height(root));
        System.out.println("Balanced BST: ");
        Node r = new Node(8);
        r.left = new Node(6);
        r.left.left = new Node(5);
        r.left.left.left = new Node(3);
        r.right = new Node(10);
        r.right.right = new Node(11);
        r.right.right.right = new Node(12);
        Node balancedRoot = balancedBST(root);
        printInOrder(balancedRoot);
        System.out.println("Height of above tree is: " + height(balancedRoot));

        Node rooot = new Node(50);
        rooot.left = new Node(30);
        rooot.left.left = new Node(5);
        rooot.left.right = new Node(20);
        rooot.right = new Node(60);
        rooot.right.left = new Node(45);
        rooot.right.right = new Node(70);
        rooot.right.right.left = new Node(65);
        rooot.right.right.right = new Node(80);

        Info info = largestBST(rooot);
        System.out.println("Largest BST in above tree is: " + maxBST);

        Node BST1 = new Node(2);
        BST1.left = new Node(1);
        BST1.right = new Node(3);

        Node BST2 = new Node(9);
        BST2.left = new Node(4);
        BST2.right = new Node(12);
        printPreOrder(mergeBST(BST1, BST2));
        System.out.println();
    }
}

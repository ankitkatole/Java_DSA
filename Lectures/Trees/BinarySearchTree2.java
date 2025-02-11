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
    }
}

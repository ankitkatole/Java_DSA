import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class BinarySearchTrees {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static boolean searchBST(Node root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        if(data < root.data){
            return searchBST(root.left, data);
        } else {
            return searchBST(root.right, data);
        }
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
    public static void printPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void printPostOrder(Node root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //case 1: no child
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2: one child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //Case 3: two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data > k1){
            printInRange(root.left, k1, k2);
        }
        if(root.data >= k1 && root.data <=  k2){
            System.out.print(root.data + " ");
        }
        if(root.data < k2){
            printInRange(root.right, k1, k2);
        }
    }

    public static void rootToLeafPath(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean validateBST(Node root){
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validate(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return validate(root.left, min, root.data) && validate(root.right, root.data, max);
    }

    public static void inOrder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        inOrder(root.left,arr);
        arr.add(root.data);
        inOrder(root.right,arr);
    }
    public static boolean isValidBST(Node root) {
        if(root == null){
            return true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        for(int i = 0; i<arr.size()-1;i++){
            if(arr.get(i) >= arr.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void mirror(Node root){
        if(root == null){
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,7,6,12,10,9,11,14};
        Node root = null;
        for (int value : values) {
                root = insert(root, value);
        }
        printInOrder(root);
        System.out.println("\n\nNode Exists?🤔: "+searchBST(root, 6));
        // delete(root, 10);
        printInOrder(root);
        System.out.println("\n\nPrinting in range👇");
        printInRange(root, 5, 12);
        System.out.println("\n\nPrinting root to leaf paths👇");
        rootToLeafPath(root, new ArrayList<>());
        System.out.println("\n\nIs Valid BST?🤔: "+validateBST(root));
        System.out.println("Is Valid BST?🤔: "+isValidBST(root));

        System.out.println("\n\nMirroring the tree👇");
        mirror(root);
        printInOrder(root);
        System.out.println();
    }
}

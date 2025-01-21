import java.lang.reflect.Array;
import java.util.*;
public class BinaryTrees3 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Kth Level
    public static void KthLevel(Node root,int k){
        if(root == null){
            return;
        }
        if(k == 0){//considering root is at level 0. for root at level 1, k should be 1.
            System.out.print(root.data+" ");
            return;
        }
        KthLevel(root.left, k-1);
        KthLevel(root.right, k-1);        
    }

    //Get Path
    public static boolean getPath(Node root, int target, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == target){
            return true;
        }
        boolean foundLeft = getPath(root.left, target, path);
        boolean foundRight = getPath(root.right, target, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    //Lowest Common Ancestor
    //Approach One
    public static Node lowestCommonAncestor(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }
    //  Approach Two
    public static Node LCA(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);
        if(rightLCA == null){
            return leftLCA;
        }
        if(leftLCA == null){
            return rightLCA;
        }
        return root;
    }


    //Minimum Distance Between Two Nodes
    //Approach One
    public static int minDistance(Node root, int n1, int n2){
        Node lca = LCA(root, n1, n2);
        return distance(lca, n1) + distance(lca, n2);
    }
    
    public static int distance(Node root, int target){
        if(root == null){
            return -1;
        }
        if(root.data == target){
            return 0;
        }
        int leftDistance = distance(root.left, target);
        int rightDistance = distance(root.right, target);
        if(leftDistance == -1 && rightDistance == -1){
            return -1;
        }
        return 1 + Math.max(leftDistance, rightDistance);
    }

    //Approach Two
    public static int minDistance2(Node root, int n1, int n2){
        Node lca = LCA(root, n1, n2);
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(lca, n1, path1);
        getPath(lca, n2, path2);
        return path1.size() + path2.size() - 2;
    }

    //K Ancestor
    //Approach One
    public static int kAncestor(Node root, int n,int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = kAncestor(root.left,n,k);
        int rightDist = kAncestor(root.right,n,k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }
    //Approach Two
    public static Node kthAncestor(Node root, int n, int k){
        if(root == null){
            return null;
        }
        ArrayList<Node> path = new ArrayList<>();
        if(!getPath(root, n, path)){
            return null;
        }
        if(k >= path.size()){
            return null;
        }
        return path.get(path.size()-k-1);
    }

    //Transform to Sum Tree
    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);
        int temp = root.data;
        root.data = rightSum + leftSum;
        return temp+root.data;
    }

    public static void printTree(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 

            while (levelSize > 0) {
                Node current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                levelSize--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print("Kth Level: ");
        KthLevel(root, 1);
        System.out.println();
        System.out.println("Lowest Common Ancestor: "+lowestCommonAncestor(root, 4, 5 ).data);
        System.out.println("Lowest Common Ancestor: "+LCA(root, 4, 5).data);
        System.out.println("Minimum Distance: "+minDistance(root, 4, 7));
        System.out.println("Minimum Distance: "+minDistance2(root, 4, 7));
        System.out.print("Kth Ancestor: ");
        kAncestor(root, 5, 2);
        System.out.println("Kth Ancestor: "+kthAncestor(root, 5, 2).data);
        sumTree(root);
        System.out.println("Transformed to Sum Tree: ");
        printTree(root);
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(15);
        root2.left.left = new Node(2);
        root2.left.right = new Node(3);
        root2.right.right = new Node(5);
        sumTree(root2);
        System.out.println("Transformed to Sum Tree: ");
        printTree(root2);
    }
}

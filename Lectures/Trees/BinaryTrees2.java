public class BinaryTrees2 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }

    
    
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftDiam = diameter(root.left);
        int leftHeight = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHeight = height(root.right);
        int selfDiam = leftHeight + rightHeight + 1;
        
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }
    
    static class NodeInfo{
        int height;
        int diameter;
    }

    public static NodeInfo diameter2(Node root){
        if(root == null){
            NodeInfo n = new NodeInfo();
            n.height = 0;
            n.diameter = 0;
            return n;
        }
        NodeInfo left = diameter2(root.left);
        NodeInfo right = diameter2(root.right);
        NodeInfo self = new NodeInfo();
        self.height = Math.max(left.height, right.height) + 1;
        self.diameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        return self;
    }

    public static boolean isSubtree(Node root, Node subTree){
        if(root == null){
            return false;
        }
        if(root.data == subTree.data){
            if(isIdentical(root, subTree)){
                return true;
            }
        }
        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
    }

    public static boolean isIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null || root1.data != root2.data){
            return false;
        }
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Diameter of the tree is (Approach 1): "+diameter(root));
        System.out.println("Diameter of the tree is (Approach 2): "+diameter2(root).diameter);

        //SubTree
        Node subTree = new Node(2);
        subTree.left = new Node(4);
        subTree.right = new Node(5);

        System.out.println(isSubtree(root, subTree)?"Given Tree if Subtree of the main tree":"Given Tree is not a Subtree of the main tree");
    }
}

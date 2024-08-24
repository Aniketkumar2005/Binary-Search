public class ValidateBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node build(Node root, int val) {
        // insert first value of array into the null node root...
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = build(root.left, val);
        } else {
            root.right = build(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        // base case
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean isValidBST (Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min,root)
                && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int value[] = {8,5,3,6,10,11,14};
        Node root = null;

        for(int i=0; i<value.length; i++){
            root = build(root, value[i]);
        }
        inorder(root);
        System.out.println();
        if(isValidBST(root, null, null)){
            System.out.println("valid");
        }
        else{
            System.out.println("Not valid");
        }
    }
}

public class PrintBST {
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
    // fucntion for print the number lie between k1 and k2
    public static void printinrange (Node root, int k1, int k2){
        //  base case
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinrange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printinrange(root.left, k1, k2);
        }
        else {
            printinrange(root.right, k1, k2);
        }
    } 

    public static void main(String[] args) {
        int value[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<value.length; i++){
            root = build(root, value[i]);
        }
        inorder(root);
        System.out.println();

        printinrange(root, 5, 12);
    }
}

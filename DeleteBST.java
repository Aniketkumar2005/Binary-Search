public class DeleteBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to insert a node into the BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        // base case
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // Method to Delete a node into the BST
    public static Node delete (Node root, int val){
        // searching the key first...
        if(root.data < val){
            root.right = delete(root.right , val);
        }
        else if (root.data > val){
            root.left = delete(root.left , val);
        }
        // here when the value is finded after searching
        else{ // case 1; for leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2; node which have their one subtree only 
            // if right is null return left or else return right 
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // case 3:
            Node IS  = findInordersuccessor (root.right); // inorder successor present in leftmost of right subtree therefor root.right is called
            root.data = IS.data;
            root.right = delete(root.right , IS.data); 
        }

        return root;
    }
    // here we get left most node in right subtree.... 
    public static Node findInordersuccessor (Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] value = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        // Build the BST by inserting values from the array
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        inorder(root);
        System.out.println();

        root = delete(root, 10);
        System.out.println();

        inorder(root);
    }
}

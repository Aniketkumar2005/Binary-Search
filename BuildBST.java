public class BuildBST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node build (Node root, int val){
        // insert first value of array into the null node root...
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = build(root.left, val);
        }
        else{
            root.right = build(root.right, val);
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
    public static void main(String[] args) {
        int value[] = {5,1,3,4,2,7};
        Node root = null;

        // itreting one by one value [] in our build node 
        for(int i=0; i<value.length; i++){
            root = build(root, value[i]);
        }
        // to cheak that our tree is sorted or not if it is sorted then its build in a correct BST sequence 
        inorder(root);
    }
}

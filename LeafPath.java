import java.util.*;
public class LeafPath {
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

        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // function for printing path
    public static void Printpath (ArrayList<Integer>path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf (Node root, ArrayList<Integer>path){
        // base case 
        if(root == null){
            return;
        }
        path.add(root.data); // add node data into the path
        // means its a leaf node 
        if(root.left == null && root.right == null){
            Printpath(path);
        }
        printRoot2Leaf(root.left, path); // calling for left itration
        printRoot2Leaf(root.right, path); // calling for right itration
        path.remove(path.size()-1); // removing from last path data(backtraking)
    }

    public static void main(String[] args) {

        int value[] = {8,5,3,6,10,11,14};
        Node root = null;

        for(int i=0; i<value.length; i++){
            root = build(root, value[i]);
        }

        printRoot2Leaf(root, new ArrayList<>());
    }
}

public class SearchBST {
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

    // Method to search for a key in the BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int[] value = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Build the BST by inserting values from the array
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }

        // Search for the key in the BST
        int key = 23;
        if (search(root, key)) {
            System.out.println("Key "+ key + " found in BST");
        } else {
            System.out.println("Key "+ key +" not found in BST");
        }
    }
}


public class BinaryTree<K extends Comparable<K>> {

    private BinaryTreeNode<K> root;

    public BinaryTree(BinaryTreeNode<K> root) {
        this.root = root;
    }

    public boolean search(K target) {
        return search(root, target);
    }

    private boolean search(BinaryTreeNode<K> currentNode, K target) {
        if (currentNode == null) {
            return false;
        }

        int compareResult = target.compareTo(currentNode.key);

        if (compareResult == 0) {
            return true; // Element found
        } else if (compareResult < 0) {
            return search(currentNode.left, target); // Recursively search the left subtree
        } else {
            return search(currentNode.right, target); // Recursively search the right subtree
        }
    }

    public static void main(String[] args) {
        // Create the binary tree manually
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(30);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(40);
        root.left.left = new BinaryTreeNode<>(10);
        root.left.right = new BinaryTreeNode<>(25);
        root.right.left = new BinaryTreeNode<>(35);
        root.right.right = new BinaryTreeNode<>(50);

        // Create the binary tree
        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);

        // Search for the element 63
        int target = 63;
        boolean found = binaryTree.search(target);

        if (found) {
            System.out.println(target + " is found in the binary tree.");
        } else {
            System.out.println(target + " is not found in the binary tree.");
        }
    }
}
class BinaryTreeNode<K> {
    K key;
    BinaryTreeNode<K> left;
    BinaryTreeNode<K> right;

    public BinaryTreeNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
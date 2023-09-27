

public class BinaryTree<K> {

    private BinaryTreeNode<K> root;

    public BinaryTree(BinaryTreeNode<K> root) {
        this.root = root;
    }

    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<K> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public static void main(String[] args) {
        // Create the binary tree manually
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Create the binary tree
        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);

        // Check if all elements are added by comparing the size
        int expectedSize = 7; // Expected number of nodes in the tree
        int actualSize = binaryTree.size();

        System.out.println("Binary Tree Size: " + actualSize);
        if (actualSize == expectedSize) {
            System.out.println("All elements are added to the binary tree.");
        } else {
            System.out.println("Not all elements are added to the binary tree.");
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
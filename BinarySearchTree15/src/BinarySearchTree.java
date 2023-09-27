public class BinarySearchTree<K extends Comparable<K>> {

    private MyBinaryNode<K> root;

    public void insert(K key) {
        root = insertRec(root, key);
    }

    private MyBinaryNode<K> insertRec(MyBinaryNode<K> currentNode, K key) {
        if (currentNode == null) {
            return new MyBinaryNode<>(key);
        }

        int compareResult = key.compareTo(currentNode.key);

        if (compareResult < 0) {
            currentNode.left = insertRec(currentNode.left, key);
        } else if (compareResult > 0) {
            currentNode.right = insertRec(currentNode.right, key);
        }

        return currentNode;
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(MyBinaryNode<K> currentNode) {
        if (currentNode != null) {
            inOrderTraversalRec(currentNode.left);
            System.out.print(currentNode.key + " ");
            inOrderTraversalRec(currentNode.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Add nodes to the BST
        bst.insert(56);
        bst.insert(30);
        bst.insert(70);

        // Perform an in-order traversal to display the BST
        System.out.println("In-order traversal:");
        bst.inOrderTraversal();
    }
}

class MyBinaryNode<K extends Comparable<K>> {
    K key;
    MyBinaryNode<K> left;
    MyBinaryNode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
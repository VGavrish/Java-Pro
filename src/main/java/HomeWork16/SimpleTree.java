package HomeWork16;

import com.sun.source.tree.Tree;

public class SimpleTree {
    private TreeNode root;

    public SimpleTree() {
        root = null;
    }

    public void add (int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.value + " ");
            traverseInOrder(node.right);
        }
    }
}

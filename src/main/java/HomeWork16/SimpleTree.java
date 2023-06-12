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
        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        }else if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        }
        return current;
    }

    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getValue() + " ");
            traverseInOrder(node.getRight());
        }
    }
}

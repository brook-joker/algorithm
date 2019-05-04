package leetcode;

public class Leet114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode leftChild = root.left;
            while (leftChild.right != null) {
                leftChild = leftChild.right;
            }
            leftChild.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}

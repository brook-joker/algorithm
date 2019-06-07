package leetcode;

public class Leet112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            root.left.val += root.val;
            left = hasPathSum(root.left, sum);
        }

        if (root.right != null) {
            root.right.val += root.val;
            right = hasPathSum(root.right, sum);
        }
        return left || right;
    }
}

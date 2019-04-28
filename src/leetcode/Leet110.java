package leetcode;

public class Leet110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (Math.abs(l - r) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

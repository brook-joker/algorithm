package leetcode;

public class Leet124 {
    int maxSum = Integer.MIN_VALUE;

    int maxAgain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxAgain(root.left), 0);
        int right = Math.max(maxAgain(root.right), 0);
        int total = root.val + left + right;
        maxSum = Math.max(maxSum, total);
        return root.val + Math.max(left, right);
    }


    public int maxPathSum(TreeNode root) {
        maxAgain(root);
        return maxSum;
    }
}

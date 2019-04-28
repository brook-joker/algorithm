package leetcode;

public class Leet654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        int max = Integer.MIN_VALUE;
        int mid = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                mid = i;
            }
        }

        TreeNode node = new TreeNode(max);
        if (mid > left) {
            node.left = constructMaximumBinaryTree(nums, left, mid - 1);
        }

        if (mid < right) {
            node.right = constructMaximumBinaryTree(nums, mid + 1, right);
        }

        return node;

    }
}

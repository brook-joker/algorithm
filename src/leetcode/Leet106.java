package leetcode;

import java.util.Arrays;

public class Leet106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int j = postorder.length - 1;
        TreeNode node = new TreeNode(postorder[j]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[j]) {
                node.left = buildTree(Arrays.copyOfRange(inorder, 0, i - 1), Arrays.copyOfRange(postorder, 0, i - 1));
                node.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, j));
            }
        }
        return node;
    }
}

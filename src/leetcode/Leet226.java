package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        TreeNode left = null;
        TreeNode right = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            left = cur.left;
            right = cur.right;
            cur.left = right;
            cur.right = left;
            if (cur.left!=null){
                queue.add(cur.left);
            }

            if (cur.right!=null){
                queue.add(cur.right);
            }

        }
        return root;
    }
}

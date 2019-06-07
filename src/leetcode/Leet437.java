package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + dfs(root, sum);
    }

    int dfs(TreeNode node, int sum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == sum) {
            count = 1;
        }
        return count + dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
    }

}

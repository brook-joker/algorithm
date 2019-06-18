package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet265 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }

    public void dfs(TreeNode root, List<String> result, String tmp) {
        if (root == null) return;
        tmp += root.val;
        if (root.left == null && root.right == null) {
            result.add(tmp);
        }
        dfs(root.left, result, tmp + "->");
        dfs(root.right, result, tmp + "->");
    }

}

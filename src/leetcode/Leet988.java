package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet988 {

    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;

    }

    public void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }

        stringBuilder.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            stringBuilder.reverse();
            String tmp = stringBuilder.toString();
            stringBuilder.reverse();

            if (ans == null) {
                ans = tmp;
            }
            if (tmp.compareTo(ans) < 0) {
                ans = tmp;
            }
        }

        dfs(root.left, stringBuilder);
        dfs(root.right, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

}

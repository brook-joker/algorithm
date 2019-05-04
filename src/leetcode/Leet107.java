package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            levelOrderBottomRecursion(result, root, 0);
        }
        return result;
    }


    public void levelOrderBottomRecursion(List<List<Integer>> result, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size() - depth - 1).add(root.val);
        levelOrderBottomRecursion(result, root.left, depth + 1);
        levelOrderBottomRecursion(result, root.right, depth + 1);
    }
}

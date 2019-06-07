package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        hasPathSum(root, sum, result, new ArrayList<>());
        return result;
    }

    public void hasPathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(tmp));
        }
        sum -= root.val;

        hasPathSum(root.left, sum, result, tmp);
        hasPathSum(root.right, sum, result, tmp);
        tmp.remove(tmp.size() - 1);

    }
}

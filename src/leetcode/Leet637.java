package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet637 {

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size(), size = count;
            double sum = 0;
            while (count > 0) {
                root = queue.pop();
                sum += root.val;
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                count--;
            }
            res.add(sum / size);
        }
        return res;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<Double> averageOfLevelsRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        if (root != null) {
            levelOrderBottomRecursion(result, root, 0);
            for (List<Integer> list : result) {
                double sum = 0;
                for (Integer integer : list) {
                    sum += integer;
                }
                res.add(sum / list.size());
            }
        }
        return res;
    }

    public void levelOrderBottomRecursion(List<List<Integer>> result, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        levelOrderBottomRecursion(result, root.left, depth + 1);
        levelOrderBottomRecursion(result, root.right, depth + 1);
    }


}

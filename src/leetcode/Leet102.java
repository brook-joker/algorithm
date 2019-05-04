package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            tmp = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                root = queue.pop();
                tmp.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                count--;
            }
            result.add(tmp);
        }
        return result;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        levelOrderRecurssion(result, root, 0);
        return result;
    }

    public void levelOrderRecurssion(List<List<Integer>> result, TreeNode root, int depth) {
        if (root == null) return;
        if (depth >= result.size() || result.get(depth) == null) {
            result.add(depth, new ArrayList<>());
        }
        result.get(depth).add(root.val);
        levelOrderRecurssion(result, root.left, depth + 1);
        levelOrderRecurssion(result, root.right, depth + 1);
    }


}

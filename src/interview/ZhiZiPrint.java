package interview;

import leetcode.TreeNode;

import java.util.*;

public class ZhiZiPrint {
    public ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (depth % 2 == 0) {
                    tmp.add(node.val);
                } else {
                    tmp.add(0, node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }
            depth++;
            result.add(tmp);
        }
        return result;
    }
}

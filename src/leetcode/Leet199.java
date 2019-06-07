package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Leet199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node =  queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
                if (size == 0){
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}

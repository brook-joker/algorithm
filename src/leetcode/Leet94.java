package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
        }
        return result;
    }


    public void inorderTraversalRecursion(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversalRecursion(root.left, list);
        list.add(root.val);
        inorderTraversalRecursion(root.right, list);
    }
}

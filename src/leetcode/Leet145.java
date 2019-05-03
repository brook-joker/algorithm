package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet145 {
    /**
     * 两个栈的实现方式
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> tmp = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !tmp.isEmpty()) {
            if (root != null) {
                tmp.add(root);
                stack.add(root);
                root = root.right;
            } else {
                root = tmp.pop();
                root = root.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }


    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
            if ((cur.left == null && cur.right == null) || pre != null && (cur.left == pre || cur.right == pre)) {
                result.add(cur.val);
                pre = cur;
                stack.pop();
            } else {
                if (cur.right != null) stack.add(cur.right);
                if (cur.left != null) stack.add(cur.left);
            }
        }
        return result;
    }
}

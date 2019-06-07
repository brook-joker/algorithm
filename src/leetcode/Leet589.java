package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 */
public class Leet589 {


    public List<Integer> preorder(Leet590.Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Leet590.Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.children != null && root.children.size() > 0) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    if (root.children.get(i) != null) {
                        stack.add(root.children.get(i));
                    }
                }
            }
        }
        return res;
    }


    void preorderRecursion(List<Integer> res, Leet590.Node root) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null) {
            for (Leet590.Node child : root.children) {
                preorderRecursion(res, child);
            }
        }
    }

}

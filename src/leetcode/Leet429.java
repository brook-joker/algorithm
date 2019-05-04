package leetcode;

import java.util.*;

public class Leet429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            LinkedList<Node> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                int count = stack.size();
                List<Integer> list = new ArrayList<>();
                while (count > 0) {
                    root = stack.pop();
                    list.add(root.val);
                    if (root.children != null && root.children.size() > 0) {
                        stack.addAll(root.children);
                    }
                    count--;
                }
                result.add(list);
            }
        }
        return result;
    }

    //递归实现
    void levelOrderRecursion(List<List<Integer>> result, Node root, int depth) {
        if (root == null) return;
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                levelOrderRecursion(result, child, depth + 1);
            }
        }
    }

}

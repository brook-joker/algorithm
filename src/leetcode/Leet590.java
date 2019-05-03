package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        Node pre = null;
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if (judge(cur, pre)) {
                result.add(cur.val);
                pre = cur;
                stack.pop();
            } else {
                if (cur == null) continue;
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.add(cur.children.get(i));
                }
            }
        }
        return result;
    }

    public boolean judge(Node cur, Node pre) {
        if (pre != null) {
            for (int i = 0; i < cur.children.size(); i++) {
                if (cur.children.get(i) == pre) {
                    return true;
                }
            }
        }
        return cur != null && cur.children.size() == 0;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

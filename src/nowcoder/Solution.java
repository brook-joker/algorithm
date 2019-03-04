package nowcoder;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackData.push(node);
        if (stackMin.isEmpty() || node <= stackMin.peek()) {
            stackMin.push(node);
        } else if (node > stackMin.peek()) {
            int nodeMin = stackMin.peek();
            stackMin.push(nodeMin);
        }
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}

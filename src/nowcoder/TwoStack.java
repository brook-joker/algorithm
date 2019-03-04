package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * <p>
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * <p>
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();
        List<Integer> res = new ArrayList<>();
        // write code here
        for (int i = 0; i < n; i++) {
            if (ope[i] > 0) {
                stackPush.push(ope[i]);
            } else if (ope[i] == 0) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
                res.add(stackPop.pop());
                while (!stackPop.empty()) {
                    stackPush.push(stackPop.pop());
                }
            }
        }
        int[] re = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            re[i] = res.get(i);
        }
        return re;
    }
}

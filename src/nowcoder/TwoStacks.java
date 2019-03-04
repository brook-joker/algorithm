package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * <p>
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * <p>
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        int[] stackHelper = new int[numbers.length];
        int i = 0, n = numbers.length, j = n;
        int cur;
        while (i < n) {
            cur = numbers[i++];
            //说明当前辅助栈中不存在元素 直接进行压栈
            if (j == n) {
                stackHelper[--j] = cur;
            } else if (cur <= stackHelper[j]) {
                stackHelper[--j] = cur;
            } else if (cur > stackHelper[j]) {
                //将辅助栈中元素依次转入原栈 知道curNumber小于辅助栈栈顶的元素
                while (j < n && cur > stackHelper[j]) {
                    numbers[--i] = stackHelper[j++];
                }
                stackHelper[--j] = cur;
            }
        }

        for (int k = 0; k < n; k++) {
            res.add(stackHelper[n - k - 1]);
        }
        return res;
    }

}

package 剑指offer;

import nowcoder.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Offer6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.add(listNode.val);
                listNode = listNode.next;
            }
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
        }

        return result;
    }


    //递归实现
    public void printListFromTailToHeadRecursion(ArrayList<Integer> result, ListNode listNode) {
        if (listNode == null) {
            return;
        }

        printListFromTailToHeadRecursion(result, listNode.next);
        result.add(listNode.val);

    }

}

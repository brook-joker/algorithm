package leetcode;

import nowcoder.ListNode;

public class Leet24 {

    //递归解法
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode node = head.next;
//        head.next = swapPairs(node.next);
//        node.next = head;
//        return node;
//    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode next;
        ListNode last = null;
        while (head != null) {
            next = head.next;
            if (next!=null){
                ListNode tmp = next.next;
                next.next = head;
                if (last!=null){
                    last.next = next;
                }
                head.next = tmp;
            }
            last = head;
            head = head.next;
        }

        return node;
    }

}

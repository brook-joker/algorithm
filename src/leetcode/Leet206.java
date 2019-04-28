package leetcode;

import nowcoder.ListNode;

public class Leet206 {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode next = null;
//        while (head!=null){
//            next = head.next;
//            head.next = pre;
//
//            pre = head;
//            head = next;
//
//        }
//
//        return pre;
//    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}

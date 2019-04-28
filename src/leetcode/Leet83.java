package leetcode;

import nowcoder.ListNode;

public class Leet83 {

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode root = head;
//        while (head != null&&head.next!=null) {
//            if (head.next.val == head.val) {
//                head.next = head.next.next;
//            }else {
//                head = head.next;
//            }
//        }
//        return root;
//    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        while (node != null && head.val == node.val) {
            node = node.next;
        }
        head.next = deleteDuplicates(node);
        return head;
    }
}

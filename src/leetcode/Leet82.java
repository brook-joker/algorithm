package leetcode;

import nowcoder.ListNode;

import java.util.List;

public class Leet82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }

        }
        return root.next;
    }

}

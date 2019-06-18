package interview;

import nowcoder.ListNode;

public class Day2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, node = head;
        while (cur != null) {
            node = cur.next;
            cur.next = pre;

            pre = cur;
            cur = node;
        }

        return pre;
    }
}

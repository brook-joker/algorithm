package leetcode;

import nowcoder.ListNode;

public class Leet876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        return low;
    }


}

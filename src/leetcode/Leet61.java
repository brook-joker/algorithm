package leetcode;

import nowcoder.ListNode;

public class Leet61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int kLength = 1;
        ListNode node = head;
        while (node.next != null) {
            kLength++;
            node = node.next;
        }
        ListNode tail = node;
        k = k % kLength;
        if (k == 0) return head;
        k = kLength - k;
        kLength = 1;
        node = head;
        while (kLength != k) {
            kLength++;
            node = node.next;
        }
        ListNode nHead = node.next;
        node.next = null;
        tail.next = head;
        return nHead;
    }

}

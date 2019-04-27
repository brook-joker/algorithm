package leetcode;

import nowcoder.ListNode;

public class Leet237 {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) {
            node = null;
        }

        ListNode next = node.next.next;
        node.val = node.next.val;
        node.next = next;
    }
}

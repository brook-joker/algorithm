package leetcode;

import nowcoder.ListNode;

public class Leet109 {


    public ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode low = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }
        return low;

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode mid = findMid(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) {
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

}

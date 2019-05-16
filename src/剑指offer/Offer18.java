package 剑指offer;

import nowcoder.ListNode;

public class Offer18 {
    //11223455
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode root = new ListNode(-1);
        ListNode cur = pHead, pre = root;
        while (cur != null) {
            ListNode next = cur.next;
            boolean isDelete = false;
            while (next != null && cur.val == next.val) {
                next = next.next;
                isDelete = true;
            }
            if (isDelete) {
                cur = next;
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = null;
        return root.next;
    }


    public ListNode deleteDuplicationRecursion(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode cur;
        if (pHead.val == pHead.next.val) {
            cur = pHead.next.next;
            while (cur != null && pHead.val == cur.val) {
                cur = cur.next;
            }
            return deleteDuplicationRecursion(cur);
        }
        cur = pHead.next;
        pHead.next = deleteDuplicationRecursion(cur);
        return pHead;

    }


}

package leetcode;

import nowcoder.ListNode;

/**
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 */
public class Leet148_merge {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, low = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(low));
    }


    /**
     * 遍历合并
     * @param l
     * @param r
     * @return
     */
    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null) cur.next = l;
        if (r != null) cur.next = r;
        return dummy.next;
    }

    /**
     * 递归合并
     * @param l
     * @param r
     * @return
     */
    public ListNode mergeRecursion(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;
        if (l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        } else {
            r.next = merge(l, r.next);
            return r;
        }
    }


}

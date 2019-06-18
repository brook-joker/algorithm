package leetcode;

import nowcoder.ListNode;

public class Leet92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //m-1
        ListNode preP = null, pre = null, cur = head, next = null, tail = null;
        for (int i = 0; i < m; i++) {
            next = cur.next;
            preP = pre;
            pre = cur;
            cur = next;
        }

        tail = pre;
        for (int i = 0; i < n - m; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (tail != null) {
            //反转之后将m和n+1连接起来
            tail.next = cur;
        }

        if (preP != null) {
            //将m-1和n连接起来
            preP.next = pre;
            return head;
        }
        return pre;

    }
}

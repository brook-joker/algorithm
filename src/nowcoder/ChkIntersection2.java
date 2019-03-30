package nowcoder;

/**
 * 单链表相交判断练习题
 * <p>
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 * <p>
 * 先找到两个链表的环形入口节点node1 node2
 * 1.如果node1和node2都为空 那么说明就没有环  直接找相交点即可
 * 2.如果node1或者node2为空 那说明不可能相交
 * 3.都为不为空的情况下再谈论:有环单链表相交
 */

public class ChkIntersection2 {
    public boolean chkInter(ListNode headA, ListNode headB) {
        // write code here
        ListNode node1 = findCircleEntrance(headA);
        ListNode node2 = findCircleEntrance(headB);
        if (node1 == null && node2 == null) {
            return chkIntersectBySingle(headA, headB);
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            if (node1 ==node2) return true;
            ListNode cur = node1.next;
            while (cur!=node1){
                if (cur == node2) return true;
                cur = cur.next;
            }
        }

        return false;
    }

    public boolean chkIntersectBySingle(ListNode headA, ListNode headB) {
        // write code here
        ListNode fast = headA, slow = headB;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next == null ? headB : fast.next.next;
            slow = slow.next == null ? headA : slow.next;
        }
        return false;
    }


    public ListNode findCircleEntrance(ListNode head) {
        ListNode fast = head, low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) break;
        }
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }


}

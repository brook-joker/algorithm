package nowcoder;

/**
 * 有环单链表相交判断练习题
 * <p>
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * <p>
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 */
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode head1Entrance = findCircleEntrance(head1);
        ListNode head2Entrance = findCircleEntrance(head2);
        if (head1Entrance == head2Entrance) return true;
        ListNode cur = head1Entrance.next;
        while (cur!=head1Entrance){
            if (cur == head2Entrance) return true;
            cur = cur.next;
        }

        return false;
    }

    public ListNode findCircleEntrance(ListNode head) {
        ListNode fast = head.next.next, low = head.next;
        while (fast != low) {
            fast = fast.next.next;
            low = low.next;
        }
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}

package nowcoder;

public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode fast = head1, slow = head2;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next == null ? head2 : fast.next.next;
            slow = slow.next == null ? head1 : slow.next;
        }
        return false;
    }
}

package nowcoder;

public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
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
}

package nowcoder;

public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) return -1;

        fast = head;
        while (fast != null) {
            if (slow == fast) {
                return fast.val;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return -1;
    }
}

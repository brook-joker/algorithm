package nowcoder;

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * <p>
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 * <p>
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        if (head == null || head.next == null) return head;
        ListNode pre = null, pRoot = new ListNode(-1);
        ListNode last = null, lRoot = new ListNode(-1);
        ListNode node = head;
        while (node != null) {
            ListNode cur = node;
            node = node.next;
            cur.next = null;
            if (cur.val <= val) {
                if (pre == null) {
                    pRoot.next = cur;
                } else {
                    pre.next = cur;
                }
                pre = cur;
            } else if (cur.val > val) {
                if (last == null) {
                    lRoot.next = cur;
                } else {
                    last.next = cur;
                }
                last = cur;
            }
        }
        //合并链表
        ListNode root = new ListNode(-1);
        head = root;
        while (pRoot.next != null) {
            root.next = pRoot.next;
            pRoot = pRoot.next;
            root = root.next;
        }
        while (lRoot.next!=null){
            root.next = lRoot.next;
            lRoot = lRoot.next;
            root = root.next;
        }
        return head.next;
    }
}

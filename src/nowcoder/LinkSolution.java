package nowcoder;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class LinkSolution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        RandomListNode cur = pHead, curCopy, next;
        //赋值节点
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        //对赋值的节点赋值random
        cur = pHead;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        //开始分割
        cur = pHead;
        RandomListNode res = pHead.next;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}

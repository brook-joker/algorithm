package nowcoder;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * <p>
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * <p>
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        ListNode root = null;
        if (A == null || A.length == 0) {
            ListNode listNode = new ListNode(val);
            listNode.next = listNode;
            return listNode;
        }
        //构建环形链表
        root = new ListNode(A[0]);
        ListNode node, pre = root;
        for (int i = 0; i < A.length - 1; i++) {
            node = new ListNode(A[nxt[i]]);
            pre.next = node;
            pre = node;
        }

        node = root.next;
        pre = root;
        boolean flag = true;
        while (node != null) {
            if (val >= pre.val && val < node.val) {
                flag = false;
                //找到合适的插入位置了
                ListNode node1 = new ListNode(val);
                node1.next = node;
                pre.next = node1;
                break;
            } else {
                pre = node;
                node = node.next;
            }
        }

        //说明当前的元素要么比整个环形链表的数据都大/小
        if (flag) {
            if (pre.val < val) {
                //要插入的元素大于整个链表的值
                ListNode node1 = new ListNode(val);
                pre.next = node1;
            } else {
                //要插入的元素小于整个链表的值
                ListNode node1 = new ListNode(val);
                node1.next = root;
                root = node1;
            }
        }

        return root;
    }
}

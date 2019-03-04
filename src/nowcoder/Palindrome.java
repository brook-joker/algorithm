package nowcoder;

import java.util.Stack;

/**
 * 请编写一个函数，检查链表是否为回文。
 * <p>
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * <p>
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return true;
        }
        ListNode fast = pHead, slow = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //逆置部分链表
        ListNode pre = reverListNode(slow);
        ListNode p = pre;

        slow = pHead;
        fast = pre;
        boolean res = true;
        while(pre!=null){
            if (pre.val != slow.val){
                res = false;
                break;
            }
            pre = pre.next;
            slow = slow.next;
        }

        //再次逆置部分链表
        reverListNode(p);

        return res;
    }


    public ListNode reverListNode(ListNode root){
        ListNode pre = null;
        ListNode next = null;
        while (root!=null){
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }

        return pre;
    }

}

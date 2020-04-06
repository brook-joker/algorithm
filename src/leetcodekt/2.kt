package leetcodekt

import nowcoder.ListNode

class `2` {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val newHead = head.next
        reverse(head, null)
        return newHead
    }

    fun reverse(node: ListNode?, pre: ListNode?) {
        if (node?.next == null) {
            return
        }
        //交换两个节点  1->2->3->4
        val next = node.next //2
        node.next = next.next //1->3->X
        next.next = node  //2->1->3->X

        if (pre != null) {
            pre.next = next
        }


        //开始下一轮递归
        reverse(node.next, node)
    }
}
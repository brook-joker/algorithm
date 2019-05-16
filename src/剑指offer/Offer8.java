package 剑指offer;

public class Offer8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;
        TreeLinkNode res = null;
        if (pNode.right != null) {
            TreeLinkNode rightNoe = pNode.right;
            while (rightNoe.left != null) {
                rightNoe = rightNoe.left;
            }
            res = rightNoe;
        } else if (pNode.next != null) {
            TreeLinkNode cur = pNode;
            TreeLinkNode parent = pNode.next;
            while (parent.next != null && cur == parent.right) {
                cur = parent;
                parent = parent.next;
            }
            res = parent;
        }
        return res;
    }

}

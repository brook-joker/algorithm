package leetcode;


import java.util.ArrayList;
import java.util.List;


public class Leet653 {




    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list  = new ArrayList<>();
        preOrder(list,root);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int res = list.get(left) + list.get(right);
            if (res == k) {
                return true;
            } else if (res > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    void preOrder(List<Integer> list, TreeNode root) {
        if (root == null){
            return;
        }
        preOrder(list,root.left);
        list.add(root.val);
        preOrder(list,root.right);
    }
}

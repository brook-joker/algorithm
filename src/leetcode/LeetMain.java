package leetcode;

import nowcoder.HeapSort;
import nowcoder.ListNode;
import 剑指offer.*;

import java.util.*;

public class LeetMain {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new HeapSort().heapSort(new int[]{1, 3, 5, 7, 2, 4, 6, 9, 8}, 9)));
        //System.out.println(new Leet215().findKthLargest(new int[]{1, 3, 5, 7, 2, 4, 6, 9, 8}, 3));
        //System.out.println(Leet988.intToString(1));
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next =listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(new Leet92().reverseBetween(listNode,2,4));

       // System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    // [-2,1,-3,4,-1,2,1,-5,4],


    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                left = i;
                right = left;
                sum = nums[i];
            } else {
                right++;
                sum += nums[i];
            }
            // array[i] = sum;
            if (res < sum) {
                l = left;
                r = right;
                res = sum;
            }

        }
        //    System.out.println("left:Index : "+ l +" right:Index "+r);
        System.out.print("最大的最长连续子序列是:");
        for (int i = l; i <= r; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return res;
    }


}

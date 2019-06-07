package leetcode;

import nowcoder.ListNode;
import 剑指offer.*;

import java.util.*;

public class LeetMain {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
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

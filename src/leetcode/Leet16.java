package leetcode;

import java.util.Arrays;

public class Leet16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(close - target)) {
                    close = sum;
                }

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return close;
    }
}

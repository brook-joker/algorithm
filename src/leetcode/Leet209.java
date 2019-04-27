package leetcode;

public class Leet209 {

    /*
     *  滑动窗口O(n)
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, minL = Integer.MAX_VALUE;
        for (; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                minL = Math.min(minL, j - i + 1);
                sum -= nums[i++];
            }
        }
        return minL == Integer.MAX_VALUE ? 0 : minL;
    }




}


package leetcode;

public class Leet154 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (l - r == 0 || nums[l] < nums[r]) return nums[0];
        while (l < r) {
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}

package leetcode;

public class Leet41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i - 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}

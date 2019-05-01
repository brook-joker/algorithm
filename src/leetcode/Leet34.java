package leetcode;

public class Leet34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int lm = mid;
                while (lm > 0 && nums[lm - 1] == target) {
                    lm--;
                }
                int rm = mid;
                while (rm < nums.length - 1 && nums[rm + 1] == target) {
                    rm++;
                }
                res[0] = lm == mid ? lm : lm++;
                res[1] = rm == mid ? rm : rm--;
                return res;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}


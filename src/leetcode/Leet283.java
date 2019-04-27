package leetcode;

public class Leet283 {
    /*
     * 解法一: 双指针找到数组0的左边和右边 然后将区域拷贝成非0元素
     * 解法二: 从0~n将非0数依次拷贝 末尾区域置0
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                nums[j++] = nums[k];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}

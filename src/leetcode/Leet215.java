package leetcode;

public class Leet215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            adujst(nums, i, n);
        }
        for (int i = n - 1; i >= n - k; i--) {
            swip(i, 0, nums);
            adujst(nums, 0, i);
        }
        return nums[n-k];
    }


    public void adujst(int[] array, int i, int n) {
        int tmp = array[i];
        for (int j = 2 * i + 1; j < n; j = 2 * j + 1) {
            if (j + 1 < n && array[j] < array[j + 1]) {
                j++;
            }
            if (array[j] > tmp) {
                array[i] = array[j];
                i = j;
            } else {
                break;
            }
        }
        array[i] = tmp;
    }

    public static void swip(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

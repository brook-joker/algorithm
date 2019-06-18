package leetcode;

public class Leet215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(nums, i, n);
        }
        for (int i = n - 1; i >= n - k; i--) {
            swip(0, i, nums);
            heapify(nums, 0, i);
        }

        return nums[n - k];
    }


    public static void heapify(int[] nums, int p, int n) {
        int child, parent = nums[p];
        for (; 2 * p + 1 < n; p = child) {
            child = 2 * p + 1;
            if (child < n - 1 && nums[child] < nums[child + 1]) child++;
            if (nums[child] > parent) {
                swip(child, p, nums);
            } else {
                break;
            }
        }

    }


    public static void swip(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

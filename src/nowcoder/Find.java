package nowcoder;

/**
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 * <p>
 * 给定有序数组arr及它的大小n，请返回所求值。
 * <p>
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 */
public class Find {
    public int findPos(int[] arr, int n) {
        // write code here
        if (arr == null || arr[0] > n - 1 || arr[n - 1] < n - 1) return -1;
        int left = 0, right = n - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

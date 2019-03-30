package nowcoder;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * <p>
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * <p>
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        return mid(arr,0,n-1,num);
    }

    public int mid(int[] arr, int l, int r, int num) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == num) {
                while (arr[mid] == num) {
                    mid--;
                }
                return mid + 1;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

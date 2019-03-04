package nowcoder;

/**
 * 快速排序
 * 对于一个int数组，请编写一个快速排序算法，对数组元素排序。
 * <p>
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * <p>
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return new int[0];
        }
        process(A, 0, n - 1);
        return A;
    }

    public void process(int[] A, int left, int right) {
        if (left < right) {
            //锚点选取
            int random = getMid(A, left, right);
            swap(A, random, right);
            int mid = partition(A, left, right);
            process(A, left, mid - 1);
            process(A, mid + 1, right);
        }
    }

    public int getMid(int[] a, int left, int right) {
        int mid = (left + right) / 2;
        int res = mid;
        //left是中位数   mid left right    right left mid
        if ((a[left] > a[mid] && a[left] < a[right]) || (a[left] > a[right] && a[left] < a[mid])) {
            res = left;
        } else if ((a[right] > a[mid] && a[right] < a[left]) || (a[right] > a[left] && a[right] < a[mid])){
            //right是中位数  left right mid    mid right left
            res = right;
        }
        return res;
    }

    public int partition(int[] a, int left, int right) {
        int pivot = left - 1;
        int index = left;
        while (index <= right) {
            if (a[index] <= a[right]) {
                swap(a, ++pivot, index);
            }
            index++;
        }
        return pivot;
    }

    public void swap(int[] A, int index1, int index2) {
        if (index1 == index2) return;
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }

}

package nowcoder;

/**
 * 希尔排序
 * 对于一个int数组，请编写一个希尔排序算法，对数组元素排序。
 * <p>
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素小于等于2000。
 * <p>
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int feet = n / 2;
        int index = 0;
        while (feet > 0) {
            for (int i = feet; i < n; i++) {
                index = i;
                while (index >= feet) {
                    if (A[index - feet] > A[index]) {
                        swap(A, index - feet, index);
                        index -= feet;
                    } else {
                        break;
                    }
                }
            }
            feet/=2;
        }
        return A;
    }

    public void swap(int[] A, int index1, int index2) {
        if (index1 == index2) return;
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}

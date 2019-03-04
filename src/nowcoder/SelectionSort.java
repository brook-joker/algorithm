package nowcoder;

/**
 * 选择排序
 * 相邻数字比较将交换
 * 对于一个int数组，请编写一个选择排序算法，对数组元素排序。
 * <p>
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * <p>
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class SelectionSort {
    /**
     * 存在优化空间: 减少交换的次数
     *
     * @param A
     * @param n
     * @return
     */
    public int[] selectionSort(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        return A;
    }


    /**
     * 存在优化空间: 减少交换的次数
     *
     * @param A
     * @param n
     * @return
     */
    public int[] selectionSortBetter(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int mini = 0;
        for (int i = 0; i < A.length - 1; i++) {
            mini = i;
            for (int j = i + 1; j < A.length; j++) {
                mini = A[mini] > A[j] ? j : mini;
            }
            swap(A, i, mini);
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

package nowcoder;

/**
 * 插入排序
 * 从第二个数字开始与前面的数字比较插入合适的位置
 * <p>
 * <p>
 * 对于一个int数组，请编写一个插入排序算法，对数组元素排序。
 * <p>
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * <p>
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j > 0; j--){
                if (A[j-1]>A[j]){
                    int tmp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = tmp;
                }
            }
        }
        return A;
    }
}

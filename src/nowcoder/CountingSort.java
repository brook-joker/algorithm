package nowcoder;

/**
 * 计数排序
 * 对于一个int数组，请编写一个计数排序算法，对数组元素排序。
 * <p>
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * <p>
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = A[i] > max ? A[i] : max;
            min = A[i] < min ? A[i] : min;
        }

        int[] array = new int[max - min + 1];
        for (int value : A) {
            array[value - min]++;
        }

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            while (array[i]-- > 0) {
                A[index++] = i + min;
            }
        }
        return A;
    }
}

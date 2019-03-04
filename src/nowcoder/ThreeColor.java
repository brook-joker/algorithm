package nowcoder;

/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * <p>
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * <p>
 * 测试样例：
 * [0,1,1,0,2,2],6
 * 返回：[0,0,1,1,2,2]
 */
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        partition(A, 0, n - 1);
        return A;
    }


    public void partition(int[] A, int left, int right) {
        int letfIndex = left;
        int rightIndex = right;
        for (int i = 0; i <= rightIndex; i++) {
            if (A[i] == 1) {
                continue;
            } else if (A[i] == 0) {
                swap(A, i, letfIndex++);
            } else if (A[i] == 2) {
                swap(A, i--, rightIndex--);
            }
        }
    }


    public void swap(int[] A, int index1, int index2) {
        if (index1 == index2) return;
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }


    

}

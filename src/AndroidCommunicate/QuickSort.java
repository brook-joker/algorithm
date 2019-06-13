package AndroidCommunicate;

import java.util.Arrays;

/**
 * 数组[l,r]
 * 寻找锚点p findP()
 * 将数组划分为大于p[p+1,r]的和小于p的区间[l,p] partition
 * 在[l,p]和[p+1,r]的区间再次寻找锚点进行划分直到只剩一个元素为止即调整正完毕
 */
public class QuickSort {


    public static void quickSort(int[] array, int left, int right) {
        if (left > right) return;
        int p = partitionDown(array, left, right);
        System.out.println(p);
        quickSort(array, left, p - 1);
        quickSort(array, p + 1, right);
    }

    private static int partitionUp(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        for (int j = left; j <= right - 1; j++) {
            if (array[j] <= pivot) {
                swip(array, i, j);
                i++;
            }
        }
        swip(array, i, right);
        return i;
    }

    private static int partitionDown(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        for (int j = left; j <= right - 1; j++) {
            if (array[j] >= pivot) {
                swip(array, i, j);
                i++;
            }
        }
        swip(array, i, right);
        return i;
    }


    public static void swip(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 5, 6, 4, 5, 0};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}

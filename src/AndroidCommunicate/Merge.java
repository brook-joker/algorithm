package AndroidCommunicate;

import java.util.Arrays;

public class Merge {

    private static void merge(int[] array) {
        merge(array, 0, array.length - 1);
    }

    private static void merge(int[] array, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        merge(array, left, mid);
        merge(array, mid + 1, right);
        mergeSort(array, left, mid, right);
    }

    private static void mergeSort(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            tmp[k++] = array[i] >= array[j] ? array[j++] : array[i++];
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= right) {
            tmp[k] = array[j++];
        }
        for (int aTmp : tmp) {
            array[left++] = aTmp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 5, 6, 4, 5, 0};
        merge(array);
        System.out.println(Arrays.toString(array));
    }
}

package nowcoder;

public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        // write code here
        if (A == null || A.length < 2) {
            return new int[0];
        }
        process(A, 0, n-1);
        return A;
    }


    public void process(int[] a, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        process(a, left, mid);
        process(a, mid + 1, right);
        merge(a, left, mid, right);
    }


    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            tmp[index++] = a[l] <= a[r] ? a[l++] : a[r++];
        }

        //左边的数组还有剩余的情况
        while (l <= mid) {
            tmp[index++] = a[l++];
        }
        //右边的数组还有剩余的情况
        while (r <= right) {
            tmp[index++] = a[r++];
        }

        for (int i = 0; i < tmp.length; i++) {
            a[left + i] = tmp[i];
        }
    }


}

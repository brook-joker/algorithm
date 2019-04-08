package nowcoder;

public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        heapSort(a, n);
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) return true;
        }
        return false;
    }


    public int[] heapSort(int[] A, int n) {
        // write code here
        for (int i = n / 2; i >= 0; i--) {
            buildMinHeap(A, i, n);
        }
        for (int i = A.length - 1; i >= 0; i--) {
            swap(A, 0, i);
            buildMinHeap(A, 0, i);
        }
        return A;
    }


    /**
     * @param array
     * @param parentIndex 待建堆的根节点
     * @param n
     */
    public void buildMinHeap(int[] array, int parentIndex, int n) {
        int child, parent;
        for (parent = array[parentIndex]; 2 * parentIndex + 1 < n; parentIndex = child) {
            child = 2 * parentIndex + 1; //左
            if (child < n - 1 && array[child] > array[child + 1]) child++;
            if (array[child] < parent) {
                array[parentIndex] = array[child];
            } else {
                break;
            }
        }
        array[parentIndex] = parent;

    }


    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }


}

package nowcoder;


public class HeapSort {
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
    public void buildMaxHeap(int[] array, int parentIndex, int n) {
        int child, parent;
        for (parent = array[parentIndex]; 2 * parentIndex + 1 < n; parentIndex = child) {
            child = 2 * parentIndex + 1; //左
            if (child < n - 1 && array[child] < array[child + 1]) child++;
            if (array[child] > parent) {
                array[parentIndex] = array[child];
            } else {
                break;
            }
        }
        array[parentIndex] = parent;

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


    public void buildMaxHeap(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int currIndex = i;
            int parentIndex = (i - 1) / 2;
            while (array[currIndex] > array[parentIndex]) {
                swap(array, currIndex, parentIndex);
                currIndex = parentIndex;
                parentIndex = (currIndex - 1) / 2;
            }
        }
    }


    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}

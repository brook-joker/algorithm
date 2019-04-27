package nowcoder;

import leetcode.Leet215;

import java.util.Arrays;

public class HeapSortCCC {

    public static void heap(int[] array) {
        //步骤一 构造初始化堆，将给定无序序列构造成（想象成）一个根堆（一般升序用大根堆，降序用小根堆）
        //找到最后一个非叶子节点的（(array.length-1)/2）自底向上构建堆
        int n = array.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            adjust(array, i, n);
        }
        //调整堆结构
        for (int i = n - 1; i >= n-2; i--) {
            swip(0, i, array);
            adjust(array, 0,i);
        }
    }


    public static void adjust(int[] array, int parentIndex, int n) {
        int tmp = array[parentIndex];
        for (int i = 2 * parentIndex + 1; i < n; i = i * 2 + 1) { //从parent的左子树开始
            if (i + 1 < n && array[i] < array[i + 1]) {
                i++;
            } //找到左右子树中最大的那个元素

            //子节点的值大于根节点的值,将子节点值赋值给父节点 （最后交换一次）
            if (array[i] > tmp) {
                array[parentIndex] = array[i];
                parentIndex = i;
            } else {
                break;
            }
        }
        array[parentIndex] = tmp; //将之前未交换的tmp值归位
    }


    public static void swip(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 7, 5, 9, 0, 6};
        System.out.println(new Leet215().findKthLargest(array,3));
    }
}

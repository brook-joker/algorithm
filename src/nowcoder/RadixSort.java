package nowcoder;

/*
 * 基数排序
 * 对于一个int数组，请编写一个基数排序算法，对数组元素排序。

   给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素均小于等于2000。

   测试样例：
    [1,2,3,5,2,3],6
    [1,2,2,3,3,5]
 */
public class RadixSort {
    public int[] radixSort(int[] A, int n) {

        // write code here
        if (A == null || A.length == 0) return A;
        int[] bucket = new int[n];
        int[] count = new int[10];
        //元素最大为2000 四位数字 遍历四次即可
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                count[j] = 0;
            }

            //统计频率
            for (int j = 0; j < n; j++) {
                count[getNumber(A[j], i)]++;
            }


            //将频率转化为索引
            for (int j = 0; j < 9; j++) {
               count[j+1] += count[j];
            }

            //数据分类
            for (int j = n - 1; j >= 0; j--) {
                int numer = getNumber(A[j], i);
                int bunckIndex = count[numer] -1;
                bucket[bunckIndex] = A[j];
                count[numer]--;
            }

            for (int j = 0; j < n; j++) {
                A[j] = bucket[j];
            }
        }
        return A;
    }

    public int getNumber(int number, int index) {
        int[] a = {1, 10, 100, 100};
        return (number / a[index] % 10);
    }

}

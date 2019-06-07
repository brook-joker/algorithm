package interview;

//1. 给定一个有序的数组和目标数，找出与目标数最近接的index，要求复杂度是log(n)的时间复杂度
public class FindXiangJIn {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 8, 11, 15, 16, 27, 38, 49};
        System.out.println(find(array, 28));
    }

    public static int find(int[] array, int target) {
        if (target <= array[0]) return array[0];
        if (target >= array[array.length - 1]) return array[array.length - 1];
        int l = 0;
        int r = array.length - 1;
        int result = findX(l, r, target, array);
        while (l < r) {
            if (result == target) {
                return result;
            }
            int mid = l + (r - l) / 2;
            if (target == array[mid]) {
                return array[mid];
            } else if (target > array[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            result = findX(l, r, target, array);
        }
        return result;
    }


    public static int findX(int left, int right, int tagret, int[] array) {
        return Math.abs(array[left] - tagret) > Math.abs(array[right] - tagret) ? array[right] : array[left];
    }
}

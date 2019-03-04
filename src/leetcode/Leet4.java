package leetcode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by maqiang on 2017/12/15.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class Leet4 {

    // TODO: 2017/12/15 先判断两个数组是否都有值 否则的话只在单个数组里面进行二分查找
    // 如果两个数组都存在
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length==0){
//            return findMedianSortedInSingleArrays(nums2);
//        }
//        if (nums2.length == 0){
//            return findMedianSortedInSingleArrays(nums1);
//        }

        int len = nums1.length + nums2.length;
        boolean isDouble = len % 2 == 0;
        int middle = isDouble ? len / 2 : len / 2 + 1;
        double mid = Double.valueOf(nums1[0] + nums2[0]) / 2;
        int i = 0, j = 0, step = 2;
        for (; step <= middle; ) {
            if (nums1[i] <= nums2[j]) {
                if (i < nums1.length - 1) {
                    i++;
                } else {
                    j++;
                }
            } else {
                if (j < nums2.length - 1) {
                    j++;
                } else {
                    i++;
                }
            }
            step++;
            if (step >= middle) {
                if (!isDouble) {
                    mid = nums1[i] >= nums2[j] ? nums2[j] : nums1[i];
                } else {
                    double next;
                    if (nums1[i] >= nums2[j]) {
                        if (i > 0 && j > 0) {
                            next = nums1[i - 1] <= nums2[j - 1] ? nums1[i - 1] : nums2[j - 1];
                        } else {
                            next = i > 0 ? nums1[i] : nums2[j];
                        }
                        mid = nums1[i];
                    } else {
                        if (i > 0 && j > 0) {
                            next = nums1[i - 1] <= nums2[j - 1] ? nums1[i - 1] : nums2[j - 1];
                        } else {
                            next = i > 0 ? nums1[i] : nums2[j];
                        }
                        mid = nums2[j];
                    }
                    mid = (next + mid) / 2;
                }
            }

        }
        return mid;
    }


    public static List<Long> john(long n) {
        // your code
        List<Long> john = new ArrayList<>();
//        john.add(0l);
//        for (int i = 1; i < n; i++) {
//            int t = Math.toIntExact(john.get((i - 1)));
//            john.add(i - ann(t + 1).get(t));
//        }
        long j = 0;
        long k = 0;
        for (int i = 0; i < n; i++) {
            if ((i - 2) % 3 == 0) {
                john.add(2 * k++ + 1);
                j = j + 2;
            } else {
                john.add(j);
            }
        }


        return john;
    }

    public static int findEvenIndex(int[] arr) {
        // your code
        if (arr.length <= 1) {
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {
            if (sum(arr, 0, i) == sum(arr, i + 1, arr.length)) {
                return i;
            }
        }
        return -1;
    }

    public static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[] {1,2,3,4,3,2,1}));
        System.out.println(findEvenIndex(new int[] {1,2,3,4,5,6}));
        System.out.println(findEvenIndex(new int[] {1,100,50,-51,1,1}));

    }
}

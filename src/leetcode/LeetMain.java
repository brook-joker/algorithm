package leetcode;


import 剑指offer.*;

import java.util.Arrays;

public class LeetMain {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{6, 9};
        int[][] d = new int[][]{a, b};
        int[] c = new int[]{2, 5};

        System.out.println(Arrays.deepToString(new Leet57().insert(d, c)));

    }


}

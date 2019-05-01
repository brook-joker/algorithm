package leetcode;

import java.util.jar.JarEntry;

public class Leet59 {
//    public int[][] generateMatrix(int n) {
//        if (n <= 0) {
//            return new int[0][0];
//        }
//        //start圈数
//        int count = 1, start = 0;
//        int[][] res = new int[n][n];
//        while (count <= n * n) {
//            //tR
//            for (int i = start; i < n - start; i++) {
//                res[start][i] = count++;
//            }
//
//            //tB
//            for (int i = start + 1; i < n - start; i++) {
//                res[i][n - start - 1] = count++;
//            }
//
//            //tL
//            for (int i = n - start - 2; i >= start; i--) {
//                res[n - start - 1][i] = count++;
//            }
//
//            //tT
//            for (int i = n - start - 2; i > start; i--) {
//                res[i][start] = count++;
//            }
//
//            start++;
//        }
//        return res;
//    }


    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] res = new int[n][n];
        int i = 0, j = 0, c = 1;
        while (c <= n * n) {
            //R
            while (j < n && res[i][j] == 0) {
                res[i][j++] = c++;
            }
            i++;
            j--;
            //B
            while (i < n && res[i][j] == 0) {
                res[i++][j] = c++;
            }
            i--;
            j--;
            //L
            while (j >= 0 && res[i][j] == 0) {
                res[i][j--] = c++;
            }
            i--;
            j++;
            //T
            while (i >= 0 && res[i][j] == 0) {
                res[i--][j] = c++;
            }
            i++;
            j++;
        }
        return res;
    }
}

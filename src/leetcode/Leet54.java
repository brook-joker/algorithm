package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int step = 0, i = step, j = step;
        int m = matrix.length;
        int n = matrix[0].length;
        while (res.size() < m * n) {
            //R
            while (res.size() < m * n && j < n - step) {
                res.add(matrix[i][j++]);
            }
            i++;
            j--;
            //B
            while (res.size() < m * n && i < m - step) {
                res.add(matrix[i++][j]);
            }
            i--;
            j--;
            //L
            while (res.size() < m * n && j >= step) {
                res.add(matrix[i][j--]);
            }
            i--;
            j++;
            //T
            while (res.size() < m * n && i > step) {
                res.add(matrix[i--][j]);
            }
            i++;
            j--;
            step++;
        }
        return res;
    }
}

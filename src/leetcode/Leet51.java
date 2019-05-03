package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] visited = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = ".";
            }
        }
        solveNQueens(res, visited, n, 0);
        return res;
    }

    public void solveNQueens(List<List<String>> res, String[][] visited, int n, int index) {
        if (index == n) {
            res.add(getResult(visited));
        } else {
            for (int i = 0; i < n; i++) {
                if (canStand(visited, index, i, n)) {
                    visited[index][i] = "Q";
                    solveNQueens(res, visited, n, index + 1);
                    visited[index][i] = ".";
                }
            }
        }
    }

    public boolean canStand(String[][] visited, int row, int cols, int n) {
        //垂直 向上扫描
        for (int i = row; i >= 0; i--) {
            if (visited[i][cols].equals("Q")) {
                return false;
            }
        }

        //对角线左上
        for (int i = row, j = cols; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j].equals("Q")) {
                return false;
            }
        }

        //对角线右上
        for (int i = row, j = cols; i >= 0 && j < n; i--, j++) {
            if (visited[i][j].equals("Q")) {
                return false;
            }
        }


        return true;
    }


    public List<String> getResult(String[][] visited) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < visited[0].length; j++) {
                sb.append(visited[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }


}

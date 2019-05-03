package leetcode;


public class Leet52 {
    public int totalNQueens(int n) {
        String[][] visited = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = ".";
            }
        }
        return solveNQueens(visited, n, 0);
    }

    public int solveNQueens(String[][] visited, int n, int index) {
        int count = 0;
        if (index == n) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                if (canStand(visited, index, i, n)) {
                    visited[index][i] = "Q";
                    count+=solveNQueens(visited, n, index + 1);
                    visited[index][i] = ".";
                }
            }
        }
        return count;
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

}

package 剑指offer;

public class Offer12 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return movingCount(threshold, visited, 0, 0, rows, cols);
    }

    public int movingCount(int threshold, boolean[][] visited, int i, int j, int rows, int cols) {
        int count = 0;
        if (check(threshold, visited, i, j, rows, cols)) {
            visited[i][j] = true;
            count = 1 + movingCount(threshold, visited, i + 1, j, rows, cols)
                    + movingCount(threshold, visited, i - 1, j, rows, cols)
                    + movingCount(threshold, visited, i, j + 1, rows, cols)
                    + movingCount(threshold, visited, i, j - 1, rows, cols);
        }

        return count;
    }

    public boolean check(int threshold, boolean[][] visited, int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i != rows && j != cols && !visited[i][j] && numberCheck(threshold, i, j);
    }


    public boolean numberCheck(int threshold, int i, int j) {
        int sum1 = 0, sum2 = 0;
        while (i != 0) {
            int n = i % 10;
            sum1 += n;
            i = i / 10;
        }
        while (j != 0) {
            int n = j % 10;
            sum1 += n;
            j = j / 10;
        }
        return threshold >= sum1 + sum2;

    }


}

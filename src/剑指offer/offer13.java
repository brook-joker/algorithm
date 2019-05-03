package 剑指offer;

public class offer13 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] matrixs = new char[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixs[i][j] = matrix[count++];
            }
        }
        boolean[][] visited;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                 visited = new boolean[rows][cols];
                if (hasPath(matrixs, visited, i, j, 0, rows, cols, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(char[][] matrix, boolean[][] visited, int i, int j, int index, int rows, int cols, char[] str) {
        if (index == str.length) return true;
        if (i < 0 || j < 0 || i == rows || j == cols || visited[i][j]) return false;
        if (str[index] == matrix[i][j]) {
            visited[i][j] = true;
            boolean isPath = hasPath(matrix, visited, i + 1, j, index + 1, rows, cols, str) ||
                    hasPath(matrix, visited, i - 1, j, index + 1, rows, cols, str) ||
                    hasPath(matrix, visited, i, j + 1, index + 1, rows, cols, str) ||
                    hasPath(matrix, visited, i, j - 1, index + 1, rows, cols, str);
            if (!isPath) {
                visited[i][j] = false;
            }
            return isPath;
        }
        return false;
    }
}

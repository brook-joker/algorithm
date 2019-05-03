package leetcode;

public class Leet79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] map = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, map, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, boolean[][] map, int i, int j, int index, String word) {
        if (index == word.length()) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[i].length || map[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(index)) {
            map[i][j] = true;
            boolean res = dfs(board, map, i + 1, j, index + 1, word) || dfs(board, map, i - 1, j, index + 1, word) ||
                    dfs(board, map, i, j + 1, index + 1, word) || dfs(board, map, i, j - 1, index + 1, word);
            if (!res) {
                map[i][j] = false;
            }
            return res;
        }
        return false;
    }


}

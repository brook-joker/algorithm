package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String str : words) {
            boolean[][] map = new boolean[board.length][board[0].length];
            boolean find = false;
            for (int i = 0; !find && i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (str.charAt(0) == board[i][j]) {
                        if (dfs(board, map, i, j, 0, str)) {
                            res.add(str);
                            find = true;
                            break;
                        }
                    }
                }
            }
        }
        return res;
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
            map[i][j] = false;
            return res;
        }
        return false;
    }

}

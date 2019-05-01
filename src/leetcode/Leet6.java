package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet6 {

    /*
     * 解题思想: 模拟从上到下行走过程 记录下每一行的数字
     *
     */
//    public String convert(String s, int numRows) {
//        if (numRows == 1) return s;
//        //存放每一行的容器
//        List<StringBuilder> rows = new ArrayList<>();
//        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
//            rows.add(new StringBuilder());
//        }
//
//        int curRow = 0;
//        boolean goingDown = false;
//
//        for (char c : s.toCharArray()) {
//            rows.get(curRow).append(c);
//            if (curRow == 0 || curRow == numRows - 1) {
//                goingDown = !goingDown;
//            }
//            curRow += goingDown ? 1 : -1;
//        }
//
//        StringBuilder res = new StringBuilder();
//        for (StringBuilder row:rows) {
//            res.append(row);
//        }
//        return res.toString();
//    }


    /*
     * 解题思想: 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
     *
     * 第 0 行的字符位于索引 k(2*numsRows-2)
     * 第 numsRows-1 中的字符位于索引 k(2*numsRows-2)+numsRows-1
     * 第i行中的字符位于索引  k(2*numsRows-2)+i以及(k+1)(2⋅numRows−2)−i 处;
     *
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;


        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                res.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    res.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return res.toString();
    }

}

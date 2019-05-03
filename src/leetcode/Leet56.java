package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leet56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int[][] result = new int[intervals.length][2];
        int[] pre = new int[2];
        pre[0] = intervals[0][0];
        pre[1] = intervals[0][1];
        int j = 0;
        int count = 0;
        result[j] = pre;
        for (int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if (pre[1] >= x) {
                count++;
                pre[1] = Math.max(pre[1], y);
                result[j] = pre;
            } else {
                j = j + 1;
                result[j] = intervals[i];
                pre = intervals[i];
            }
        }
        int[][] r = new int[intervals.length - count][2];
        System.arraycopy(result, 0, r, 0, j + 1);
        return r;
    }
}

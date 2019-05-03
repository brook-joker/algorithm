package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leet57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] tmp = new int[intervals.length+1][2];
        System.arraycopy(intervals, 0, tmp, 0, intervals.length);
        tmp[intervals.length] = newInterval;
        Arrays.sort(tmp, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int[][] result = new int[tmp.length][2];
        int[] pre = new int[2];
        pre[0] = tmp[0][0];
        pre[1] = tmp[0][1];
        int j = 0;
        int count = 0;
        result[j] = pre;
        for (int i = 1; i < tmp.length; i++) {
            int x = tmp[i][0];
            int y = tmp[i][1];
            if (pre[1] >= x) {
                count++;
                pre[1] = Math.max(pre[1], y);
                result[j] = pre;
            } else {
                j = j + 1;
                result[j] = tmp[i];
                pre = tmp[i];
            }
        }
        int[][] r = new int[tmp.length - count][2];
        System.arraycopy(result, 0, r, 0, j + 1);
        return r;
    }
}

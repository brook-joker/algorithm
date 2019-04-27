package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int x = 0, y = 0, cx = 0, cy = 0, countX = 0, countY = 0;
        for (int num : nums) {
            if ((cx == 0 || num == x) && num != y) {
                ++cx;
                x = num;
            } else if (cy == 0 || num == y) {
                ++cy;
                y = num;
            } else {
                --cx;
                --cy;
            }
        }

        for (int num : nums) {
            if (x == num) countX++;
            if (y == num) countY++;
        }

        if (countX > nums.length / 3) {
            res.add(x);
        }

        if (countY > nums.length / 3 && x != y) {
            res.add(y);
        }
        return res;
    }
}

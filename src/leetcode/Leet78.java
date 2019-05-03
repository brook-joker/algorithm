package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, res, tmp, 0);
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> result, List<Integer> sub, int index) {
        result.add(sub);
        for (int i = index; i < nums.length; i++) {
            List<Integer> sub1 = new ArrayList<>(sub);
            sub1.add(nums[i]);
            dfs(nums, result, sub1, i + 1);
        }
    }

}

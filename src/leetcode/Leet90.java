package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, tmp, 0);
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> result, List<Integer> sub, int index) {
        result.add(sub);
        for (int i = index; i < nums.length; i++) {
            List<Integer> sub1 = new ArrayList<>(sub);
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            sub1.add(nums[i]);
            dfs(nums, result, sub1, i + 1);

        }
    }
}

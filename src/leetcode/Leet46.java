package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
     //   backtrack(list.size(), 0, list, result);
        dfs(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }


    public void backtrack(int n, int first, List<Integer> nums, List<List<Integer>> result) {
        if (first == n) {
            result.add(nums);
            System.out.println(nums);
        }

        for (int i = first; i < n; i++) {
            System.out.println("i: " + i + "----" + "first: " + first);
            Collections.swap(nums, first, i);
            backtrack(n, first + 1, nums, result);
            Collections.swap(nums, first, i);
        }
    }



    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(res, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }



}

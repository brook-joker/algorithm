package leetcode;

public class Leet153 {
    //O(N) 找到突变的那个点
//    public int findMin(int[] nums) {
//        int res = nums[0];
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i]>nums[i+1]){
//                res = nums[i+1];
//                break;
//            }
//        }
//        return res;
//    }

    //o(logN)
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (l - r == 0 || nums[l] < nums[r]) return nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }


}

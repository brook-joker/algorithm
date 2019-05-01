package leetcode;

public class Leet27 {
//    public int removeElement(int[] nums, int val) {
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[i] != val) {
//                nums[i++] = nums[j];
//            }
//        }
//        return i;
//    }


    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                nums[j] = nums[n-1];
                n--;
            }

        }
        return n;
    }
}

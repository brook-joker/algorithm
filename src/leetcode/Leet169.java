package leetcode;

public class Leet169 {
    public int majorityElement(int[] nums) {
        int x = 0, cx = 0;
        for (int num : nums) {
            if (cx == 0 || num == x) {
                x = num;
                cx++;
            } else {
                cx--;
            }
        }
        return x;
    }
}

package leetcode;

public class Leet167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[]{-1,-1};
        while (left < right) {
            int res = numbers[left] + numbers[right];
            if (res == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (res > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}

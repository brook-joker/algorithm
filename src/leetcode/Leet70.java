package leetcode;

public class Leet70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = result;
        }
        return result;
    }
}

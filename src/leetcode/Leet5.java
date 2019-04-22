package leetcode;

public class Leet5 {

    // O(N3)
    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isEchoString(str)) {
                    res = res.length() >= str.length() ? res : str;
                }
            }
        }
        return res;
    }


    // O(N2)

    /**
     * 三种思路:
     * <p>
     * 1.把每个字母当成回文串的中心
     * 这里要考虑两种情况,回文串的长度为奇数或者偶数情况.
     * <p>
     * 2. 把每个字母当成回文串的结束
     * 3. dp[i][j]表示字符串从j到i是否是为回文串,即当s[j] == s[i]如果dp[i-1][j+1]也是回文串,
     * 那么字符串从j到i也是回文串,即dp[i][j]为真
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null) return "";
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (i - j + 1 > res.length())) {
                    res = s.substring(j, i + 1);
                }
            }
        }

        return res;
    }


    /**
     * 中心扩展法
     * 考虑奇偶性
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数
            int len1 = expandAroundCenter(s, i, i);
            //偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    /**
     * 马拉车算法
     *
     * @param s
     * @return
     */
    public String longestPalindromeSpecial(String string) {
        if (string == null || string.length() < 1) return "";
//-----------------------------------
        //转换字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringBuilder.append("#");
        }
        //-----------------------------------
        int rightIndex = 0;
        int centerIndex = 0;
        //求len中的最大
        int answer = 0;
        //answer最大时的中心
        int index = 0;
        int len[] = new int[stringBuilder.length()];
        for (int i = 1; i < stringBuilder.length(); i++) {
            //当rightIndex > i，那么我们就在rightIndex - i 与len[2 * centerIndex - i](len[j])，取得最小值
            //因为当i + len[j] < rightIndex时，我们就把len[i]更新为len[j]
            //但是如果i + len[j] >= rightIndex时，我们暂且将len[i]定更新为rightIndex - i,超出的部分需要我们一个一个的匹配
            if (rightIndex > i) {
                len[i] = Math.min(rightIndex - i, len[2 * centerIndex - i]);
            } else {
                len[i] = 1;
            }
            //一个一个匹配
            //要么是超出的部分，要么是i > rightIndex
            while (i - len[i] >= 0 && i + len[i] < stringBuilder.length()
                    && stringBuilder.charAt(i - len[i]) == stringBuilder.charAt(i + len[i])) {
                len[i]++;
            }
            //当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            //至于为什么会这样做，理解一下rightIndex和centerIndex的含义
            if (len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }
            if (len[i] > answer) {
                answer = len[i];
                index = i;
            }
        }
        //截取字符串
        //为什么index - answer + 1,因为len[i] - 1才是原来的回文字符串长度，而answer记录的是len中最大值
        return stringBuilder.substring(index - answer + 1, index + answer).replace("#", "");
    }


    public boolean isEchoString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}

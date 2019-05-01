package leetcode;

public class Leet38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder res = new StringBuilder();
        String lastStr = countAndSay(n - 1);
        int count = 0;
        char cur = lastStr.charAt(0);
        for (int i = 0; i < lastStr.length(); i++) {
            if (cur == lastStr.charAt(i)) {
                count++;
            } else {
                res.append(count).append(cur);
                cur = lastStr.charAt(i);
                count = 1;
            }
        }
        res.append(count).append(cur);
        return res.toString();
    }
}

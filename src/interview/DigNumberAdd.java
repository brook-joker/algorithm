package interview;

import java.util.regex.Pattern;

public class DigNumberAdd {

    /**
     * 如果字符串里面有非数字的字符怎么处理？
     * 是否需要考虑正负的情况
     *
     * @param a
     * @param b
     * @return
     */
    public static String add(String a, String b) {
        if (!isNumber(a) || !isNumber(b)) return "";

        char[] numsA = a.toCharArray();
        char[] numsB = b.toCharArray();
        int i = numsA.length - 1;
        int j = numsB.length - 1;
        int k = Math.max(i, j) + 1;
        int curResult = 0;
        int carry = 0;
        int[] result = new int[k + 1];

        while (k >= 0) {
            int aInt = i < 0 ? 0 : numsA[i--] - '0';
            int bInt = j < 0 ? 0 : numsB[j--] - '0';
            curResult = aInt + bInt + carry;
            carry = curResult > 9 ? 1 : 0;
            curResult %= 10;
            result[k--] = curResult;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (result[0] != 0) stringBuilder.append(result[0]);
        for (int l = 1; l < result.length; l++) {
            stringBuilder.append(result[l]);
        }

        return stringBuilder.toString();

    }

    public static boolean isNumber(String args) {
        if (args == null) return false;
        Pattern pattern = Pattern.compile("^[+\\-]?[\\d]+$");
        return pattern.matcher(args).find();
    }

    public static void main(String[] args) {
        // System.out.println(isNumber(""));
        System.out.println(add("19999", "67895"));
    }
}

package leetcode;

import java.util.HashMap;

public class Leet13 {
    //从左到右  如果当前的值大于右边的值  则加上该值
    // 如果当前的值小于右边的值 则减去该值
    public int romanToInt(String s) {
        int result = 0;
        int value = getValueByRoman(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            int nextValue = getValueByRoman(s.charAt(i + 1));
            if (value >= nextValue) {
                result += value;
            } else {
                result -= value;
            }
            value = nextValue;
        }
        result += value;
        return result;
    }

    private static int getValueByRoman(char roman) {
        if ('I' == (roman)) return 1;
        if ('V' == (roman)) return 5;
        if ('X' == (roman)) return 10;
        if ('L' == (roman)) return 50;
        if ('C' == (roman)) return 100;
        if ('D' == (roman)) return 500;
        if ('M' == (roman)) return 1000;
        throw new IllegalArgumentException("not found value:" + roman);
    }
}

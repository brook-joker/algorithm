package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leet17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String str = getStr(digits.charAt(i));
            if (!str.equals("")) {
                tmp.add(str);
            }
        }
        return combine(res, tmp, 0, new StringBuilder());
    }

    private String getStr(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";

        }
    }


    private List<String> combine(List<String> res, List<String> strings, int i, StringBuilder tmp) {
        if (i == strings.size() - 1) {
            for (int j = 0; j < strings.get(i).length(); j++) {
                res.add(tmp.append(strings.get(i).charAt(j)).toString());
                tmp.deleteCharAt(tmp.length() - 1);
            }
        } else {
            for (int j = 0; j < strings.get(i).length(); j++) {
                combine(res, strings, i + 1, tmp.append(strings.get(i).charAt(j)));
                tmp.deleteCharAt(tmp.length() - 1);
            }

        }
        return res;
    }
}

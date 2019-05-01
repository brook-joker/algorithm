package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet784 {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        return search(res, S.toCharArray(), "", S.length(), 0);
    }


    public List<String> search(List<String> res, char[] ch, String tmp, int n, int step) {
        if (n == step) {
            res.add(tmp);
        } else {
            if (isLetter(trans(ch[step]))) {
                tmp = tmp + ch[step];
                search(res, ch, tmp, n, step + 1);
                tmp = tmp.substring(0, tmp.length() - 1);
                tmp = tmp + trans(ch[step]);
                search(res, ch, tmp, n, step + 1);
            }else {
                tmp = tmp + ch[step];
                search(res, ch, tmp, n, step + 1);
            }
        }
        return res;
    }


    private char trans(char c) {
        char ch;
        if (c >= 'A' && c <= 'Z') {
            ch = (char) (c + 32);
        } else if (c >= 'a' && c <= 'z') {
            ch = (char) (c - 32);
        } else {
            ch = c;
        }
        return ch;
    }

    private boolean isLetter(char c){
        return (c >= 'A' && c <= 'Z')||(c >= 'a' && c <= 'z');
    }

}

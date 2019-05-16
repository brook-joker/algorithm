package 剑指offer;

public class Offer5 {

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.toString().length() == 0) {
            return "";
        }
        int countBlank = 0;
        char[] chars = str.toString().toCharArray();
        for (char c : chars) {
            if (c == ' ') countBlank++;
        }
        int newLength = countBlank * 2 + str.length();
        char[] result = new char[newLength];
        int i = chars.length - 1;
        int j = newLength - 1;
        while (i >= 0) {
            if (chars[i] == ' ') {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';

            } else {
                result[j--] = chars[i];
            }
            i--;
        }
        return new String(result);

    }

}

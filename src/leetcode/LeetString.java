package leetcode;

public class LeetString {
    /**
     * 字符串的全排列
     * @param str
     * @param start
     * @param end
     * @param b
     */
    private static void get_Subset(String str, int start, int end, boolean[] b) {
        if (start == end) {//当start==end时，即集合中的所有元素都已经在或者不在该子集中，输出该子集后，return跳出该层递归。
            for (int i = 0; i < end; i++) {
                if (b[i]) {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.print(" ");
        } else {
            b[start] = false;//代表数组中索引为start的元素不在该子集中
            get_Subset(str, start + 1, end, b);//而后进入递归，元素索引向后加一，同样索引为start+1的元素也有在或者不在该子集中两种可能性
            b[start] = true;
            get_Subset(str, start + 1, end, b);
        }
    }
}

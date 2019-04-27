package leetcode;

public class Leet278 {


    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        return find(0, n);
    }

    /**
     * 千万不能在找到一个错误版本后无脑左移 如果左边的全都是错误版本 且版本数量过多的话会超出时间限制
     * @param left
     * @param right
     * @return
     */
    public int find(int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            return find(left, mid);
        } else {
            return find(mid + 1, right);
        }

    }
}

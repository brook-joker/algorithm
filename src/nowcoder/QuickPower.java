package nowcoder;

import java.math.BigInteger;

/**
 * 快速N次方练习题
 * <p>
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * <p>
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 * <p>
 * 测试样例：
 * 2,3
 * 返回：8
 */
public class QuickPower {
    public int getPower(int k, int N) {
        // write code here
        BigInteger res = BigInteger.ONE;
        BigInteger tmp = BigInteger.valueOf(k);
        BigInteger mod = BigInteger.valueOf(1000000007);
        for (; N != 0; N >>= 1) {
            if ((N & 1) != 0) {
                res = res.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
            res = res.mod(mod);
            tmp = tmp.mod(mod);
        }
        return res.mod(mod).intValue();
    }


    public int getPower1(int k, int N) {
        // write code here
        if (N == 0) return 1;
        if (N == 1) return k;
        int n = (N & 1) == 0 ? N / 2 : (N - 1) / 2;
        BigInteger m = (N & 1) == 0 ? BigInteger.ONE : BigInteger.valueOf(k);
        BigInteger tmp = BigInteger.valueOf(getPower(k, n / 2));
        tmp = tmp.multiply(tmp).multiply(m);
        tmp = tmp.mod(BigInteger.valueOf(1000000007));
        return tmp.intValue();
    }


}

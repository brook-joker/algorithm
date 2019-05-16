package 剑指offer;

public class Offer16 {

//    public double Power(double base, int exponent) {
//        if (base == 0 || base == 1 || exponent == 0 || exponent == 1) {
//            return base;
//        }
//
//        double sum = 1.0;
//        boolean flag = exponent < 0;
//        for (int i = 0; i < Math.abs(exponent); i++) {
//            sum *= base;
//        }
//
//        return flag ? 1 / sum : sum;
//    }


    /**
     *
     *           a^(n/2) * a^(n/2)  n为偶数
     *   a^n =
     *           a^((n-1)/2) * a^((n-1)/2) * a  n为奇数
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        //使用右移运算符>>代替除以2
        double result = Power(base, exponent >> 1);
        result *= result;
        //使用位与运算符代替求余运算符%判断奇偶数
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }


}

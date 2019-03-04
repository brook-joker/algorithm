package nowcoder;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * <p>
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * <p>
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        if (n == 0) {
            return A;
        } else {
            int tmp = A[n - 1];
            reverseStack(A, n - 1);
            A[A.length - n] = tmp;
            return A;
        }
    }


    public void reverseArrayPrint(int[] a ,int n){
        if (n == 0){
            System.out.println("结束");
            return;
        }else {
            int tmp = a[n-1];
            System.out.println("前"+tmp);
            reverseArrayPrint(a,n-1);
            System.out.println("后"+tmp);
        }
    }
}

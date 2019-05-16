package 剑指offer;

public class Offer10 {
    public int Fibonacci(int n) {
        if (n == 1||n == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;

    }
}

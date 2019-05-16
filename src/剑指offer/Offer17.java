package 剑指offer;

public class Offer17 {
    public void printNumber(int n) {
        char[] numbers = new char[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            printNumberRecursion(numbers, n, 0);
        }

    }


    void printNumberRecursion(char[] number, int length, int index) {
        if (index == length - 1) {
            System.out.println(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            printNumberRecursion(number, length, index + 1);
        }
    }

}

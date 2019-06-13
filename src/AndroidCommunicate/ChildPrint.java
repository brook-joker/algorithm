package AndroidCommunicate;

public class ChildPrint {

    public static void printChildNumber(int[] array, int k) {
        if (k == 1) {
            for (int anArray : array) {
                System.out.print(anArray);
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            swap(array, i, k - 1);
            printChildNumber(array, k - 1);
            swap(array, i, k - 1);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        printChildNumber(new int[]{1, 2, 3,}, 3);
    }

}

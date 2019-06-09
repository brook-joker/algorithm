package interview;

public class SuperClass {
    public static int value = 123;
    static {
        System.out.println("Superclass init");
    }

    public static void test() {
        System.out.println("Superclass test");
    }
}

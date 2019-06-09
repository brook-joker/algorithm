package interview;

public class StaticMain {


    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + "start");
            new DeadLoopClass();
            System.out.println(Thread.currentThread() + "end");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}

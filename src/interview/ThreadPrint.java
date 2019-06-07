package interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程打印有序数组
 */
public class ThreadPrint {
    static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        print();
    }

    static void print() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ThreadTest3 thread1 = new ThreadTest3(atomicInteger);
        ThreadTest3 thread2 = new ThreadTest3(atomicInteger);
        ThreadTest3 thread3 = new ThreadTest3(atomicInteger);
        while (atomicInteger.get()<array.length) {
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }


    public static class ThreadTest3 extends Thread {
        private AtomicInteger count;

        public ThreadTest3(AtomicInteger count) {
            this.count = count;
        }

        @Override
        public void run() {
            System.out.println(array[count.getAndAdd(1)]);
        }
    }
}

package interview;


import java.util.LinkedList;
import java.util.Queue;

public class ProductAndConsumer {
    private final static Queue<String> mProducts = new LinkedList<String>();


   static class ProductThread extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (mProducts) {
                System.out.println(Thread.currentThread().getName() + " 开始添加产品");
                mProducts.add(Thread.currentThread().getName());
                mProducts.notifyAll();
            }
        }
    }

    static class ConsumerThread extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (mProducts) {
                try {
                    while (mProducts.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + " 队列为空");
                        System.out.println(Thread.currentThread().getName() + " 调用wait方法");
                        mProducts.wait();
                        System.out.println(Thread.currentThread().getName() + " wait方法结束");
                    }
                    String product = mProducts.poll();
                    System.out.println(Thread.currentThread().getName() + " 取出第一个产品为：" + product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConsumerThread consumerThread = new ConsumerThread();
        ConsumerThread consumerThread1 = new ConsumerThread();
        ProductThread productThread = new ProductThread();
        consumerThread.start();
        consumerThread1.start();

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                    productThread.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
    }

}

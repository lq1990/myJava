package cn.wendaocp.javase.multithread.info;



/**
 * 太多的同步锁，会造成死锁。
 * 如何解决死锁的问题：生产者消费者模式
 *
 * @author lq
 * create 2020-02-08 21:43
 */
public class SyncDemo03 {

    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();

        Test t1 = new Test(g, m);
        Test2 t2 = new Test2(g, m);

        new Thread(t1).start();
        new Thread(t2).start();


    }


}

class Test implements Runnable {
    Object goods;
    Object money;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }

    }

    public void test() {
        synchronized (goods) {
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (money) {

            }

        }

        System.out.println("一手给钱");

    }


}

class Test2 implements Runnable {
    Object goods;
    Object money;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }

    }

    public void test() {
        synchronized (money) {
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (goods) {

            }

        }

        System.out.println("一手交货");

    }


}


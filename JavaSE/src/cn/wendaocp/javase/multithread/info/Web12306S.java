package cn.wendaocp.javase.multithread.info;

/**
 * @author lq
 * create 2020-02-07 18:47
 */
public class Web12306S implements Runnable {

    private boolean flag = true;

    private int num = 50;

    @Override
    public void run() {
        while (flag) {
//            test1();
//            test2();
//            test3();
            test4();
        }


    }

    // 线程不安全
    public void test1() {
        if (num <=0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" 抢到了 "+ num--);
    }

    // 同步方法
    public synchronized void test2() {
        if (num <=0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +" 抢到了 "+ num--);
    }

    // 同步块
    public void test3() {

        synchronized (this) {
            if (num <=0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +" 抢到了 "+ num--);

        }

    }

    // 锁定范围 小
    public void test4() {

        synchronized ((Integer)num) { // 只锁了num，但还有flag没锁. 锁定的一般应是obj
            if (num <=0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +" 抢到了 "+ num--);

        }

    }

}

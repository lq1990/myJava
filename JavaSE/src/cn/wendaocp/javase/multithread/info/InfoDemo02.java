package cn.wendaocp.javase.multithread.info;

/**
 * @author lq
 * create 2020-02-07 18:24
 */
public class InfoDemo02 {

    public static void main(String[] args) {
        MyThread it1 = new MyThread();
        MyThread it2 = new MyThread();

        Thread t1 = new Thread(it1, "> 挨踢1");
        Thread t2 = new Thread(it2, ">>          挨踢2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        it1.stop();
        it2.stop();

    }

}

package cn.wendaocp.javase.multithread.create;

/**
 * 实现Runnable
 *   方便共享资源
 *
 *
 * @author lq
 * create 2020-02-06 16:05
 */
public class Web12306 implements Runnable {

    private int num = 50;


    public static void main(String[] args) {
        // real obj
        Web12306 web = new Web12306();

        // proxy，可以创建多个代理
        Thread t1 = new Thread(web, "黄牛1");
        Thread t2 = new Thread(web, " 黄牛2");
        Thread t3 = new Thread(web, "  黄牛3");

        t1.start();
        t2.start();
        t3.start();

    }

    @Override
    public void run() {
        while (true) {
            if (num <=0) break;

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" 抢到了 "+ num--);
        }

    }
}

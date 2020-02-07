package cn.wendaocp.javase.multithread.info;

/**
 * @author lq
 * create 2020-02-07 18:09
 */
public class MyThread implements Runnable {
    private boolean flag = true;
    private int num = 0;

    @Override
    public void run() {
        while (flag) {

            System.out.println(Thread.currentThread().getName()+" "+num++);

        }

    }

    public void stop() {
        this.flag = false;
    }

}

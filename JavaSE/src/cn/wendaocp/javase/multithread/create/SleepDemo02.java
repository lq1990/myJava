package cn.wendaocp.javase.multithread.create;

/**
 * @author lq
 * create 2020-02-07 15:20
 */
public class SleepDemo02 {

    public static void main(String[] args) {
        Web12306 web = new Web12306();

        // proxy
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "路人乙");
        Thread t3 = new Thread(web, "路人丙");

        // start
        t1.start();
        t2.start();
        t3.start();

    }


}



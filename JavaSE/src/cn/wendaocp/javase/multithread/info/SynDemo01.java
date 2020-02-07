package cn.wendaocp.javase.multithread.info;

/**
 * @author lq
 * create 2020-02-07 18:48
 */
public class SynDemo01 {

    public static void main(String[] args) {

        Web12306S web = new Web12306S();

        Thread t1 = new Thread(web, "甲");
        Thread t2 = new Thread(web, "乙");
        Thread t3 = new Thread(web, "丙");

        t1.start();
        t2.start();
        t3.start();

    }

}

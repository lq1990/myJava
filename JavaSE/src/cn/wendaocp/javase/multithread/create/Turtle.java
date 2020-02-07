package cn.wendaocp.javase.multithread.create;

/**
 * @author lq
 * create 2020-02-06 12:43
 */
public class Turtle extends Thread {

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("> 乌龟慢悠悠 "+i+" 步");
        }

    }

}

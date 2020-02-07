package cn.wendaocp.javase.multithread.create;


/**
 * 模拟龟兔赛跑
 * 1. 创建多线程，继承 Thread，重写 run() （run 是线程体，一切从run开始）
 * 2. 使用线程： 创建子类对象，调用对象.start()
 *
 * @author lq
 * create 2020-02-06 12:31
 */
public class Rabbit extends Thread {

    @Override
    public void run() { // 线程体
        for (int i=0; i<100; i++) {
            System.out.println(">> 兔子跑了 "+i + "步");
        }
    }

}


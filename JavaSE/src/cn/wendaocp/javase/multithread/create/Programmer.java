package cn.wendaocp.javase.multithread.create;

/**
 * 1. 使用 Runnable 创建线程，重写run。   =》 真实角色
 * 2. 启动多线程，使用静态代理
 *    1. 创建真实角色
 *    2. 创建代理角色 + 真实角色引用
 *    3. 调用start()
 *
 * @author lq
 * create 2020-02-06 15:52
 */
public class Programmer implements Runnable {


    @Override
    public void run() {
        // 线程体
        for (int i=0; i<100; i++) {
            System.out.println("coding... "+i);
        }
    }

}

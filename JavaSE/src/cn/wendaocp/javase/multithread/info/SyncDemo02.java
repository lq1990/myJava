package cn.wendaocp.javase.multithread.info;

import java.sql.Time;

/**
 * 单例设计模式：确保一个类只有一个对象。
 *  外部只能使用，但不能new。
 *
 * @author lq
 * create 2020-02-08 15:26
 */
public class SyncDemo02 {


    public static void main(String[] args) {

        System.out.print(Thread.currentThread().getName()+": ");
        new JvmThread(1).start();

        JvmThread t1 = new JvmThread(100);
        JvmThread t2 = new JvmThread(500);
        JvmThread t3 = new JvmThread(200);

        t1.start();
        t2.start();
        t3.start();

    }

}

class JvmThread extends Thread {

    private long time;

    public JvmThread() {

    }

    public JvmThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        Jvm ins1 = Jvm.getInstance(time);
        System.out.println(Thread.currentThread().getName()+": "+ins1);
    }
}


/**
 * 一个类只有一个对象
 *  懒汉式
 *  1. 构造器私有化
 *  2. 声明一个静态变量
 *
 */
class Jvm {
    private static Jvm instance = null;

    // 构造器私有
    private Jvm() {

    }


    public static Jvm getInstance(long time) {

        if (null == instance) { // 当instance已经创建好，就不用进入if了
            synchronized (Jvm.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(time);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    instance = new Jvm();
                }

            }
        }

        return instance;
    }

    public static synchronized Jvm getInstance2(long time) {
        if (instance == null) {

            try {
                Thread.sleep(time);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Jvm();
        }

        return instance;
    }

}



class MyJvm3 {

    private static class JVMHolder {
        private static MyJvm3 instance = new MyJvm3();
    }

    private MyJvm3() {

    }

    public static MyJvm3 getInstance() {
        return JVMHolder.instance; // 静态内部类只在使用时才加载
    }

}


















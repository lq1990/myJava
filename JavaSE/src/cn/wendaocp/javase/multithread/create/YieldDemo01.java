package cn.wendaocp.javase.multithread.create;



/**
 * yield: 暂停当前正在执行的线程对象，并执行其他线程。
 *   即放弃拥有cpu资源
 * 是static方法
 *
 * @author lq
 * create 2020-02-07 14:43
 */
public class YieldDemo01 implements Runnable {

    public static void main(String[] args) {

        Thread t1 = new Thread(new YieldDemo01());
        t1.start();


        for (int i=0; i<100; i++) {
            if (i%10 == 0) {
                System.out.print("---");
                Thread.yield(); // 暂停本线程，是静态方法
            }

            System.out.println("main " + i);
        }


    }


    @Override
    public void run() {

        for (int i=0; i<100; i++) {

            System.out.println("yield " + i);
        }

    }


}

package cn.wendaocp.javase.multithread.create;

/**
 * join: 合并线程
 *
 * @author lq
 * create 2020-02-07 14:33
 */
public class JoinDemo01 implements Runnable {

    public static void main(String[] args) {


        Thread t1 = new Thread(new JoinDemo01()); // 新生
        t1.start(); // 就绪
        // cpu调度 进入运行


        for (int i=0; i<100; i++) {
            if (i==50) {
                try {
                    t1.join(); // 当i=50时，main要等待t1线程的结束

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(">> main "+i);

        }


    }


    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("join "+ i);
        }
    }

}

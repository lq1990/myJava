package cn.wendaocp.javase.multithread.info;

/**
 * isAlive()
 * getName()
 * currentThread()
 *
 * @author lq
 * create 2020-02-07 18:13
 */
public class InfoDemo01 {

    public static void main(String[] args) {
        MyThread it = new MyThread();

        Thread proxy = new Thread(it);
        proxy.setName("挨踢");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName());

        proxy.start();
        System.out.println("启动后的状态："+proxy.isAlive());

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        it.stop();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("停止后的状态："+proxy.isAlive());

    }


}

package cn.wendaocp.javase.multithread.create;

/**
 * 1. 创建子对象obj
 * 2. obj.start()
 *
 * @author lq
 * create 2020-02-06 12:29
 */
public class RabbitApp {

    public static void main(String[] args) {
        System.out.println(RabbitApp.class);

        // 创建子类对象
        Rabbit rab = new Rabbit();
        Turtle tur = new Turtle();

        // 调用start() 开一个新线程，具体调用顺序由cpu管控
        rab.start(); // 不用手动调用run，而是调用start
        tur.start();


        for (int i=0; i<100; i++) {
            System.out.println("main runs " + i + " step");
        }

        System.out.println("--- main end ---");

    }



}

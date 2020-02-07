package cn.wendaocp.javase.multithread.create;

/**
 * @author lq
 * create 2020-02-06 15:55
 */
public class ProgrammerApp {

    public static void main(String[] args) {
        // 1. 真实角色
        Programmer programmer = new Programmer();

        // 2. 代理角色 + 真实角色引用
        Thread th1 = new Thread(programmer);
        System.out.println(th1.getName());


        // 3. start()
        th1.start();

        // main
        for (int i=0; i<100; i++) {
            System.out.println("> main... " +i);
        }

    }

}

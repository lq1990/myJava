package cn.wendaocp.javase.multithread.leetcode;

import java.rmi.server.ExportException;

/**
 * @author lq
 * create 2020-02-09 18:23
 */
public class Print {

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        // t1, t2, t3


    }

}


class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

class PrintFirst implements Runnable {

    @Override
    public void run() {
        System.out.println("first");
    }

}

class PrintSecond implements Runnable {

    @Override
    public void run() {
        System.out.println("second");
    }

}

class PrintThird implements Runnable {

    @Override
    public void run() {
        System.out.println("third");
    }

}

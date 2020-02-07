package cn.wendaocp.javase.multithread.create;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep
 * 倒计时
 *
 * @author lq
 * create 2020-02-07 14:58
 */
public class SleepDemo01 implements  Runnable{

    public static void main(String[] args) {
//        Date startTime = new Date(System.currentTimeMillis());
        Date endTime = new Date(System.currentTimeMillis()+10*1000);

//        long start = startTime.getTime();
        long end = endTime.getTime();

        while (true) {
            System.out.println(
                    new SimpleDateFormat("mm:ss")
                            .format(endTime));

            endTime = new Date(endTime.getTime() - 1000);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (end - 10000 > endTime.getTime()) break;

        }



    }


    public static void main0(String[] args) {
        int num = 10;
        while (num >=0 ) {
            System.out.println(num--);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {

    }
}

package cn.wendaocp.javase.multithread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer
 * @author lq
 * create 2020-02-09 15:24
 */
public class TimerDemo01 {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy");
            }
        }, new Date(System.currentTimeMillis()+1000));

    }

}

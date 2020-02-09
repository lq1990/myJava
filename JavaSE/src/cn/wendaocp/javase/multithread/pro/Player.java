package cn.wendaocp.javase.multithread.pro;

/**
 * 生产者
 * @author lq
 * create 2020-02-09 14:43
 */
public class Player implements Runnable {

    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }


    @Override
    public void run() {

        for (int i=0; i<20; i++) {
            if (i%2 == 0) {
                m.play(Thread.currentThread().getName() + "> 左青龙");

            } else {
                m.play( Thread.currentThread().getName()+ ">> 右白虎");
            }

        }

    }

}

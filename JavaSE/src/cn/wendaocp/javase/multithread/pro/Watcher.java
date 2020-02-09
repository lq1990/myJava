package cn.wendaocp.javase.multithread.pro;

/**
 * 消费者
 * @author lq
 * create 2020-02-09 14:44
 */
public class Watcher implements Runnable {

    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            m.watch();
        }
    }

}

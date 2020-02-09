package cn.wendaocp.javase.multithread.pro;

/**
 *
 * 一个场景，共同的资源
 * 生产者消费者模式：信号灯法
 *
 * wait() 等待， 会释放锁。而sleep不释放锁。
 * notify() notifyAll() 唤醒
 * 注： wait() notify() 和synchronized 一起使用
 *
 *
 * @author lq
 * create 2020-02-09 14:41
 */
public class Movie {

    private String pic;

    /**
     * 信号灯
     * true：表示生产者生产，消费者等待。 当生产者完成后 通知消费者
     * false: 消费者消费，生产者等待。 当消费者消费后，通知生产者。
     *
     */
    private boolean flag = true;

    /**
     * 播放
     * @param pic
     */
    public synchronized void play(String pic) {
        if (!flag) {
            // 此时消费者消费， 生产者等待。当消费者消费后 再通知生产者

            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // 开始生产
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产: "+pic);

        // 生产完毕
        this.pic = pic;

        // 通知消费者
        this.notify();

        // 生产者停下
        this.flag = false;

    }

    /**
     * 观看
     */
    public synchronized void watch() {

        if (flag) {
            // 消费者等待。当生产者生产后，通知消费者
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 开始消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 消费完毕
        System.out.println("消费了: "+pic);

        // 通知生产者
        this.notifyAll();

        // 消费者停下
        this.flag = true;
    }

}

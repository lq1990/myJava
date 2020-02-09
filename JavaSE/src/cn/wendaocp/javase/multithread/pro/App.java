package cn.wendaocp.javase.multithread.pro;

/**
 * @author lq
 * create 2020-02-09 14:47
 */
public class App {

    public static void main(String[] args) {
        // 共同资源
        Movie m = new Movie();

        // threads
        Player p = new Player(m);
        Watcher w = new Watcher(m);

        new Thread(p).start();
        new Thread(w).start();


    }

}

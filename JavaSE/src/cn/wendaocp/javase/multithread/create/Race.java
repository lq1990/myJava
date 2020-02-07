package cn.wendaocp.javase.multithread.create;

import java.util.concurrent.*;

/**
 * Callable<返回值类型>
 * @author lq
 * create 2020-02-06 16:22
 */
public class Race implements Callable<Integer> {
    private String name; // 名称
    private long time; // 延时时间
    private boolean flag = true;
    private int step = 0;

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(time); // 延时
            step++;
        }

        return step;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}

class Call {
    public static void main(String[] args) throws Exception {
        // 创建线程
        ExecutorService ser = Executors.newFixedThreadPool(2);

        Race turtle = new Race("乌龟", 500);
        Race rabbit = new Race("兔子", 200);

        // 获取值
        Future<Integer> res1 = ser.submit(turtle);
        Future<Integer> res2 = ser.submit(rabbit);

        // 只让跑2s
        Thread.sleep(2000);
        turtle.setFlag(false); // 停止线程体中循环
        rabbit.setFlag(false);

        try {
            Integer num1 = res1.get();
            Integer num2 = res2.get();
            System.out.println("乌龟跑了 " + num1);
            System.out.println("兔子跑了 " + num2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 停止服务
        ser.shutdownNow();


    }
}

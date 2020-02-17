package cn.wendaocp.dubbo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * provider
 * @author lq
 * create 2020-02-16 14:20
 */
public class MainApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("provider.xml");

        System.out.println("Provider 容器启动。。。");

        ctx.start();
        System.in.read();


    }
}

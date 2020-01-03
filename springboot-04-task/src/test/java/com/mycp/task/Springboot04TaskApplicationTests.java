package com.mycp.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 发送简单邮件
     *
     */
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开始");
        message.setTo("18765937410@163.com");
        message.setFrom("845603270@qq.com");

        mailSender.send(message);

    }

    /**
     * 测试：带附件的邮件发送
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        // 1. 创建一个复杂的消息邮件
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("通知-吃饭了");
        helper.setText("<b style='color:red;'>水煮肉</b>", true);

        // 附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\china\\Pictures\\1.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\china\\Pictures\\2.jpg"));

        helper.setTo("18765937410@163.com");
        helper.setFrom("845603270@qq.com");

        mailSender.send(message);

    }


}

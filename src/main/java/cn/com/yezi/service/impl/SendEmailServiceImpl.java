package cn.com.yezi.service.impl;

import cn.com.yezi.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/**
 * @description:
 * @author:wxf
 * @date:2020/1/27
 * @version:
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.receivers}")
    private String receivers;

    @Override
    public String send(String sender, String receiver, String title, String text) {

        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送方
        mainMessage.setFrom(sender);
        //接收方
        mainMessage.setTo(receiver);
        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
        return "success";
    }

    @Override
    public String sendHtml(String sender, String receiver, String subject, String content) throws Exception{
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        //发送方
        helper.setFrom(sender);
        //接收方
        helper.setTo(receiver);
        //邮件主题
        helper.setSubject(subject);
        //邮件内容
        helper.setText(content,true);
        jms.send(message);
        return "sendHtml success";
    }

    @Override
    public String sendMailMessage(String title, String content) {

        String recs[] = receivers.split(";");

        SimpleMailMessage message = new SimpleMailMessage();
        //腾讯的限制，发送人必须与发送邮箱相同，不同会报异常
        message.setFrom(username);
        message.setTo(recs);
        message.setSubject(title);
        message.setText(content);
        jms.send(message);
        return "success";
    }
}

package cn.com.yezi.service;

/**
 * @description:
 * @author:wxf
 * @date:2020/1/27
 * @version:
 */
public interface SendEmailService {

    /**
     * 发送邮件
     * @param sender   发送方
     * @param receiver 接收方
     * @param title    发送的标题
     * @param text     发送的内容
     * @return
     */
    public String send(String sender,String receiver,String title,String text);

    /**
     * 发送邮件模板
     * @param sender
     * @param receiver
     * @param subject
     * @param content
     * @return
     */
    public String sendHtml(String sender,String receiver,String subject, String content) throws Exception;

    /**
     * 群发邮件
     * @param title
     * @param content
     * @return
     */
    public String sendMailMessage(String title, String content);
}

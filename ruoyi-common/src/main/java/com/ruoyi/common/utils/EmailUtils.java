package com.ruoyi.common.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ruoyi.common.config.Global;

/**
 * 邮件工具类
 * @author Li Dehuan
 * @date 2019年7月9日
 *
 */
public class EmailUtils {
	
	
	/**
	 * 发邮件
	 * @param someone 收件人邮箱
	 * @param subject 主题
	 * @param content 内容
	 * @return ok=成功，other=失败信息
	 */
	public static String sendEmail(String someone, String subject, String content){
        Properties props = new Properties();
        props.setProperty("mail.host", Global.getConfig("ruoyi.email.host"));
        props.setProperty("mail.smtp.auth", "true");
        
        Authenticator authenticator = new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Global.getConfig("ruoyi.email.username"), Global.getConfig("ruoyi.email.password"));
            }
        };
        Session session = Session.getDefaultInstance(props, authenticator);
        session.setDebug(true);
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(Global.getConfig("ruoyi.email.sendFrom")));
            message.setRecipients(RecipientType.TO,InternetAddress.parse(someone));
            //message.setRecipients(RecipientType.TO,InternetAddress.parse("测试的接收的邮件多个以逗号隔开"));
            try {
                message.setSubject(subject);
                message.setContent(content,"text/html;charset=UTF-8");
                Transport.send(message);
                
                return "ok";		// 成功
                
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        } catch (AddressException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

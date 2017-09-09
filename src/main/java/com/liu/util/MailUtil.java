package com.liu.util;

import com.liu.Constant.ConstantPath;
import com.liu.configure.MailConf;
import com.liu.model.People;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by liujiayu on 2017/9/9.
 */
public class MailUtil {

    public static void sendRegister(MailConf mailConf, People people, String ip){
        MimeMessage msg = new MimeMessage(mailConf.getSession());
        Transport transport = mailConf.getTransport();
        try{
            msg.setFrom(new InternetAddress(ConstantPath.MAIL_NAME));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(people.getMail()));
            msg.setSubject(people.getName() + "请激活");

            String value = FileUtil.filePathConcat(ConstantPath.NET_PRIFIX, ip, ":",
                    ConstantPath.PROT, "/mail/recive/register?",
                    "value=" + Base64Util.encode64(people.getId() + ";" + System.currentTimeMillis()));
            msg.setContent("<a href=\"" + value + "\">激活地址</a>", "text/html;charset=utf-8");

            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (AddressException e){
            e.printStackTrace();
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String to = "1459963090@qq.com";

        String from = "m18800105727@163.com";

        Properties prop = System.getProperties();
        prop.put("mail.host","smtp.163.com" );
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", true);

        Session session = Session.getInstance(prop);
        try {
            Transport ts=session.getTransport();
            ts.connect("m18800105727@163.com", "20124206999smtp");
            MimeMessage mm=new MimeMessage(session);
            mm.setFrom(new InternetAddress(from));
            mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mm.setSubject("JAVA");
            mm.setContent("<a href=\"http://172.27.180.181:8080/\">项目</a> ", "text/html;charset=gbk");

            ts.sendMessage(mm, mm.getAllRecipients());

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

}

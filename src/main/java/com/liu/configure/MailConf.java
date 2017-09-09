package com.liu.configure;

import com.liu.Constant.ConstantPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

/**
 * Created by liujiayu on 2017/9/9.
 */
@Configuration
public class MailConf {

    private  Transport transport = null;

    private Session session = null;

    @Bean(name="properties")
    public Properties properties(){
        Properties properties = System.getProperties();
        properties.put("mail.host","smtp.163.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);
        return properties;
    }

    @Bean(name="session")
    public Session session(Properties properties){
        return session = Session.getInstance(properties);
    }

    @Bean(name="trans")
    public Transport transport(Session session){
        try{
            transport = session.getTransport();
            transport.connect(ConstantPath.MAIL_NAME, ConstantPath.MAIL_PWD);
        } catch (NoSuchProviderException e){
            e.printStackTrace();
        } catch (MessagingException e){
            e.printStackTrace();
        }
        return transport;
    }

    public Transport getTransport(){
        return this.transport;
    }

    public Session getSession(){
        return this.session;
    }

}

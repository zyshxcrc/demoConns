package Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by liuziyang on 2017/7/27.
 */
@Configuration
public class MailConfig {
    @Value("${mail.host}")
    private String host;
    @Value("${mail.username}")
    private String userName;
    @Value("${mail.password}")
    private String passWord;


    @Bean
    public JavaMailSenderImpl javaMailSender(){
        System.out.println(host+userName+passWord);
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(465);
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setUsername(userName);
        javaMailSender.setPassword(passWord);

        return javaMailSender;
    }
}

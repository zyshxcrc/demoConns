package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by liuziyang on 2017/7/27.
 */
@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(SimpleMailMessage message){
        javaMailSender.send(message);
    }
}

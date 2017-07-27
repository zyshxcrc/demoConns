package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MQProducer;
import service.MailSenderService;

/**
 * Created by liuziyang on 2017/7/27.
 */
@Controller
public class MailSender {
    @Autowired
    private MailSenderService mailSenderService;
    @Autowired
    private MQProducer mqProducer;

    @RequestMapping("/sendMail")
    public String sendMail(){
        mqProducer.sendDataToQueue("queue_one","test");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("2880096403@qq.com");//收件人邮箱地址
        message.setFrom("891990586@qq.com");//收件人
        message.setSubject("spring自带javamail发送的邮件");//主题
        message.setText("hello this mail is from spring javaMail ");//正文
        mailSenderService.send(message);
        return "main";
    }
}

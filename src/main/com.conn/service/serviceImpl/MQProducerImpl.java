package service.serviceImpl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MQProducer;

/**
 * Created by liuziyang on 2017/7/27.
 */
@Service("mqProducer")
public class MQProducerImpl implements MQProducer{
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendDataToQueue(String queueKey, Object object) {
        amqpTemplate.convertAndSend(object);
    }
}

package listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuziyang on 2017/7/27.
 */
@Component
public class QueueListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
        System.out.println("11");
    }
}

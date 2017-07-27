package service;

/**
 * Created by liuziyang on 2017/7/27.
 */
public interface MQProducer {
    void sendDataToQueue(String queueKey, Object object);
}

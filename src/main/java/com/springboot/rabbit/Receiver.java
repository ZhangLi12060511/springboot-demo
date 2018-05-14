package com.springboot.rabbit;

import com.springboot.config.RabbitmqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author zhangbenben on 2018/5/14 0014
 */
@Component
@RabbitListener(queues = RabbitmqConfig.LOGIN_QUEUE)
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void process(Object message) {
        System.out.println("Receiver  : " + message);
    }
}

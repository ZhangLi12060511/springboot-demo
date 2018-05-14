package com.springboot.rabbit;

import com.springboot.config.RabbitmqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangbenben on 2018/5/14 0014
 */
@Component
public class Sender {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Object message){
        String sendMsg = "用户登陆成功,用户信息为："+message;
        logger.info("发送mq消息"+sendMsg+"成功");
        this.amqpTemplate.convertAndSend(RabbitmqConfig.LOGIN_QUEUE,sendMsg);
    }
}

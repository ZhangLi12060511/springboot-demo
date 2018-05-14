package com.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhangbenben on 2018/5/14 0014
 */
@Configuration
public class RabbitmqConfig {
    public final  static String LOGIN_QUEUE = "loginQueue";

    /**
     * @date: 2018/5/14 0014 2018-05-14
     * @description:声明topic队列
     */
    @Bean
    public Queue queueMessage(){
        return new Queue(LOGIN_QUEUE);
    }
    @Bean
    public TopicExchange loginExchange(){
        return new TopicExchange("loginExchange");
    }
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange loginExchange){
        return BindingBuilder.bind(queueMessage).to(loginExchange).with("topic.#");
    }



}

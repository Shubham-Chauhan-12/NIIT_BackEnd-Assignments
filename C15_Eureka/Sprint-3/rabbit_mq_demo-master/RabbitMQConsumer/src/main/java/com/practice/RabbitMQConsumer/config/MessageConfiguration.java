/*
 * Author Name: Rohit
 * Date: 09-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.practice.RabbitMQConsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {


    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter()    {
        return new  Jackson2JsonMessageConverter();
    }

}


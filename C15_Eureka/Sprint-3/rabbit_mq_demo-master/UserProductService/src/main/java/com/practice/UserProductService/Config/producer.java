/*
 * Author Name: Rohit
 * Date: 10-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.practice.UserProductService.Config;

import com.practice.UserProductService.domain.User;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class producer {
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    public producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sendmsg(UserDTO userDTO)
    {
        rabbitTemplate.convertAndSend(directExchange.getName(),"userproductkey",userDTO);
    }
}


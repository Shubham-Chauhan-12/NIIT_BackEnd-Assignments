/*
 * Author Name: Rohit
 * Date: 10-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.practice.RabbitMQConsumer.config;

import com.practice.RabbitMQConsumer.domain.User;
import com.practice.RabbitMQConsumer.service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserServiceImpl userService;
    @RabbitListener(queues = "userproductqueue")
    public void getData(UserDTO userDTO)
    {
      //  System.out.println(" consumer data--"+userDTO);
      //  sout
        User user=new User();
        user.setMobileNo(userDTO.getMobileNo());
        user.setUserName(userDTO.getUserName());
        user.setUserId(userDTO.getUserId());
       user.setPassword(userDTO.getPassword());
       userService.saveUser(user);
    }
}

/*
 * Author Name: Rohit
 * Date: 09-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.practice.RabbitMQConsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.RabbitMQConsumer.config.UserDTO;
import com.practice.RabbitMQConsumer.domain.User;
import com.practice.RabbitMQConsumer.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

}

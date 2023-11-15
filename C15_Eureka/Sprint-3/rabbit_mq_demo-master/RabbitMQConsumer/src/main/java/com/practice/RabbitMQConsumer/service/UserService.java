package com.practice.RabbitMQConsumer.service;

import com.practice.RabbitMQConsumer.config.UserDTO;
import com.practice.RabbitMQConsumer.domain.User;

public interface UserService {

    User saveUser(User user);
}

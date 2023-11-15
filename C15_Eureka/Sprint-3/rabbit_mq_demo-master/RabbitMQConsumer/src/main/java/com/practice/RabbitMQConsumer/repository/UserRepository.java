package com.practice.RabbitMQConsumer.repository;

import com.practice.RabbitMQConsumer.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
}

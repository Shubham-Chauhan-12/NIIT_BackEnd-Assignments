package com.practice.UserProductService.repository;

import com.practice.UserProductService.domain.Product;
import com.practice.UserProductService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Integer> {

   // User findByUserId(int userId);

}

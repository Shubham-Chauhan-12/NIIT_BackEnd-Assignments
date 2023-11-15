package com.practice.UserProductService.service;

import com.netflix.discovery.converters.Auto;
import com.practice.UserProductService.Config.UserDTO;
import com.practice.UserProductService.Config.producer;
import com.practice.UserProductService.domain.Product;
import com.practice.UserProductService.domain.User;
import com.practice.UserProductService.exception.ProductAlreadyExistException;
import com.practice.UserProductService.exception.ProductNotFoundException;
import com.practice.UserProductService.exception.UserAlreadyExistException;
import com.practice.UserProductService.exception.UserNotFoundException;
import com.practice.UserProductService.proxy.UserProxy;
import com.practice.UserProductService.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserProxy userProxy;

    @Autowired
    producer prod;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProxy userProxy){
        this.userRepository = userRepository;
        this.userProxy = userProxy;

    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if(userRepository.findById(user.getUserId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        userProxy.register(user);
        return userRepository.insert(user);
    }

    @Override
    public User addProductForUser(int userId, Product product) throws ProductAlreadyExistException {
      /*  if(userRepository.findById(product.getProductId()).isPresent()) {
            throw new ProductAlreadyExistException();
        }
        User user = userRepository.findByUserId(userId);

        if(user.getProductList()==null){
            user.setProductList(Arrays.asList(product));
        }else{
            List<Product> products=user.getProductList();
            products.add(product);
            user.setProductList(products);
        }
        return userRepository.save(user);*/ return null;
    }

    @Override
    public List<User> getAllProducts() throws ProductNotFoundException {
        return userRepository.findAll();
    }

    @Override
    public User deleteUserAndProduct(int userId,int productId) throws UserNotFoundException,ProductNotFoundException {
        boolean result;
        if(userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException();
        }
        User user=userRepository.findById(userId).get();
        List<Product> productList=user.getProductList();
        result=productList.removeIf(obj->obj.getProductId()==productId);

        if(!result){throw  new ProductNotFoundException();}

        user.setProductList(productList);
        return userRepository.save(user);
    }

    @Override
    public   Optional<User> getByUserId(int userId) {
        Optional<User> user=userRepository.findById(userId);
    try {
        System.out.println(" user data fetched from client request---" + user.get().toString());
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.get().getUserId());
        userDTO.setUserName(user.get().getUserName());
        userDTO.setPassword(user.get().getPassword());
        userDTO.setMobileNo(user.get().getMobileNo());

        prod.sendmsg(userDTO);
    }
    catch(Exception ex)
    {
        System.out.println(ex.getStackTrace());
    }
        return user;
    }


}
